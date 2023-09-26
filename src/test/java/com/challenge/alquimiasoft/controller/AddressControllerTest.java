//package com.challenge.alquimiasoft.controller;
//
//import com.challenge.alquimiasoft.IRepository.IAddressRepository;
//import com.challenge.alquimiasoft.model.Address;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//@RunWith(MockitoJUnitRunner.class)
//public class AddressControllerTest {
//
//    @Mock
//    private IAddressRepository addressRepository;
//
//    @InjectMocks
//    private AddressController addressController;
//
//    @Test
//    public void testGetAllAddresses() {
//        // Mock the behavior of the IAddressRepository.findAll() method
//        List<Address> addresses = Arrays.asList(new Address(1L, "Main Street"), new Address(2L, "Elm Street"));
//        when(addressRepository.findAll()).thenReturn(addresses);
//
//        // Get all addresses from the controller
//        List<Address> allAddresses = addressController.getAllAddresses();
//
//        // Assert that the returned list of addresses is as expected
//        assertThat(allAddresses).hasSize(2);
//        assertThat(allAddresses.get(0).getId()).isEqualTo(1L);
//        assertThat(allAddresses.get(0).getStreet()).isEqualTo("Main Street");
//        assertThat(allAddresses.get(1).getId()).isEqualTo(2L);
//        assertThat(allAddresses.get(1).getStreet()).isEqualTo("Elm Street");
//    }
