package com.challenge.alquimiasoft.controller;
//
import com.challenge.alquimiasoft.IRepository.IAddressRepository;
import com.challenge.alquimiasoft.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class AddressControllerTest {



    private MockMvc mockMvc;

    @MockBean
    private IAddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        // Define the behavior of the mock repository
        List<Address> mockAddressList = new ArrayList<>();

        when(addressRepository.findAll()).thenReturn(mockAddressList);
    }

    @Test
    public void testGetAllAddresses() throws Exception {
        // Perform a GET request to the "/all" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]")); // Adjust this JSON content based on your expected results
    }

    @Test
    public void testConstructor() {
        Address address = new Address("Main Street", "Anytown", "USA", null);

        assertThat(address.getCalle()).isEqualTo("Main Street");
        assertThat(address.getCiudad()).isEqualTo("Anytown");
        assertThat(address.getPais()).isEqualTo("USA");
        assertThat(address.getClient()).isNull();
    }





}

