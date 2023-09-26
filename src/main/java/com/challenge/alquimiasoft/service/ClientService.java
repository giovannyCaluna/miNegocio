package com.challenge.alquimiasoft.service;

import com.challenge.alquimiasoft.IRepository.IClientRepository;
import com.challenge.alquimiasoft.model.Client;
import com.challenge.alquimiasoft.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.extensions.compactnotation.CompactData;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;
import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clientRepository;

    public Iterable<Client> searchClients(String name, String identification) {
        Iterable<Client> filteredList =  clientRepository.findAll();
        List<Client> finalList = new ArrayList<>();
        filteredList.forEach(client -> {
            if(client.getName().contains(name) ||
                    client.getIdentificationNumber().contains(identification))
            {
                finalList.add(client);
            }

        });

        return finalList;


    }
}
