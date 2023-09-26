package com.challenge.alquimiasoft.controller;

import com.challenge.alquimiasoft.IRepository.IAddressRepository;
import com.challenge.alquimiasoft.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    @Autowired

    private IAddressRepository addresRepository;

    @GetMapping("/all")
    public List<Address> getAllAddresses() {


        return addresRepository.findAll();
    }

}