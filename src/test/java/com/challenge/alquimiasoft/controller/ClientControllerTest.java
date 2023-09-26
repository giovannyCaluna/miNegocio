package com.challenge.alquimiasoft.controller;


import com.challenge.alquimiasoft.IRepository.IAddressRepository;
import com.challenge.alquimiasoft.IRepository.IClientRepository;
import com.challenge.alquimiasoft.model.Address;
import com.challenge.alquimiasoft.model.Client;
import com.challenge.alquimiasoft.pojo.ClientRequest;
import com.challenge.alquimiasoft.pojo.CreateUserAndMatrizRequest;
import com.challenge.alquimiasoft.pojo.UserIdentificationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClientRepository clientRepository;

    @MockBean
    private IAddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        // Define the behavior of the mock repositories
        List<Client> mockClientList = new ArrayList<>();
        // Add mock clients here if needed

        when(clientRepository.findAll()).thenReturn(mockClientList);
        when(clientRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(null));
        // Mock other repository interactions as needed
    }

    @Test
    public void testGetAllClients() throws Exception {
        // Perform a GET request to the "/all" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]")); // Adjust this JSON content based on your expected results
    }

    @Test
    public void testGetClientById() throws Exception {
        Long clientId = 1L; // Replace with an actual client ID
        // Mock the behavior of the clientRepository.findById method
        when(clientRepository.findById(clientId)).thenReturn(Optional.ofNullable(null));

        // Perform a GET request to the "/{id}" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/" + clientId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]")); // Adjust this JSON content based on your expected results
    }

    @Test
    public void testCreateClient() throws Exception {
        // Create a mock ClientRequest object
        ClientRequest clientRequest = new ClientRequest("DNI","12345","Alex","alex@gmail.com","0984",null);
        Client newClient = new Client("DNI","12345","Alex","","0984",null);
        when(clientRepository.save(any(Client.class))).thenReturn(newClient);

        // Perform a POST request to the "/createClient" endpoint with JSON content
        mockMvc.perform(MockMvcRequestBuilders.post("/clients/createClient")
                        .content(asJsonString(clientRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateClientAndMatriz() throws Exception {

        Client newclient = new Client("DNI","12345","Alex","","0984",null);
        Address newAdress  = new Address("Main Street", "Anytown", "USA", null);
        CreateUserAndMatrizRequest request = new CreateUserAndMatrizRequest(newclient,newAdress);
        when(clientRepository.save(any(Client.class))).thenReturn(newclient);
        when(addressRepository.save(any(Address.class))).thenReturn(newAdress);

        // Perform a POST request to the "/createClientAndMatriz" endpoint with JSON content
        mockMvc.perform(MockMvcRequestBuilders.post("/clients/createClientAndMatriz")
                        .content(asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSearchClients() throws Exception {
        // Create a mock UserIdentificationRequest object
        List<Client> lClient= new ArrayList<>();
        Client newclient = new Client("DNI","12345","Alex","","0984",null);
lClient.add(newclient);
        UserIdentificationRequest request = new UserIdentificationRequest("Alex","12345");

        when(clientRepository.findBynameOrIdentification(any(String.class), any(String.class))).thenReturn(lClient);

        // Perform a POST request to the "/lookForClient" endpoint with JSON content
        mockMvc.perform(MockMvcRequestBuilders.post("/clients/lookForClient")
                        .content(asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()); // Adjust this JSON content based on your expected results
    }

    @Test
    public void testUpdateClient() throws Exception {
        // Create a mock Client object
        Client newclient = new Client("DNI","12345","Alex","","0984",null);

        when(clientRepository.save(any(Client.class))).thenReturn(newclient);

        // Perform a POST request to the "/update" endpoint with JSON content
        mockMvc.perform(MockMvcRequestBuilders.post("/clients/update")
                        .content(asJsonString(newclient))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveClient() throws Exception {
        // Create a mock Client object
        List<Address> lAddress= new ArrayList<>();
        Client newclient = new Client("DNI","12345","Alex","","0984",null);
        Address newAddress = new Address("Main Street", "Anytown", "USA", null);
        lAddress.add(newAddress);
        when(addressRepository.findByClientId(any(Long.class))).thenReturn(lAddress);

        // Perform a POST request to the "/remove" endpoint with JSON content
        mockMvc.perform(MockMvcRequestBuilders.post("/clients/remove")
                        .content(asJsonString(newclient))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateAddress() throws Exception {
        // Create a mock Address object
        Address newAddress = new Address("Main Street", "Anytown", "USA", null);

        Address address = new Address(/* provide necessary data */);
        when(addressRepository.save(any(Address.class))).thenReturn(newAddress);

        // Perform a POST request to the "/create" endpoint with JSON content
        mockMvc.perform(MockMvcRequestBuilders.post("/clients/create")
                        .content(asJsonString(address))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Helper method to convert objects to JSON format
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
