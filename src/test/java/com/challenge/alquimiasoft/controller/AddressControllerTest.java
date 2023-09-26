package com.challenge.alquimiasoft.controller;

import com.challenge.alquimiasoft.IRepository.IAddressRepository;
import com.challenge.alquimiasoft.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AddressControllerTest {
    private IAddressRepository addresRepository;
    private AddressController addressController;
  //  @Test
    public void testGetAllAddresses() {
        // Arrange
        List<Address> expectedAddresses = Collections.emptyList();
        when(addresRepository.findAll()).thenReturn(expectedAddresses);

        // Act
        List<Address> actualAddresses = addressController.getAllAddresses();

        // Assert
        assertEquals(expectedAddresses.size(), actualAddresses.size()    );
    }

}
