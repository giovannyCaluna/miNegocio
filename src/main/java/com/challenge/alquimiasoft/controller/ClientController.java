package com.challenge.alquimiasoft.controller;

import com.challenge.alquimiasoft.IRepository.IAddressRepository;
import com.challenge.alquimiasoft.IRepository.IClientRepository;
import com.challenge.alquimiasoft.model.Address;
import com.challenge.alquimiasoft.model.Client;
import com.challenge.alquimiasoft.model.CreateUserAndMatrizRequest;
import com.challenge.alquimiasoft.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClientService clientService;
    @Autowired
    private IClientRepository clientRepository;

@Autowired
    private IAddressRepository addressRepository;

    @GetMapping("all")
    public ResponseEntity<Iterable<Client>> getAllClients() {
        return ResponseEntity.ok(clientRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Address>> getClientById(@PathVariable Long id) {
    return ResponseEntity.ok(addressRepository.findAll()
            .stream()
            .filter(address -> address.getClient().getId().equals(1))
            .collect(Collectors.toList()));
    }

    @PostMapping("createClient")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientRepository.save(client));
    }


    @PostMapping("createClientAndMatriz")
    public ResponseEntity<Client> createClientandMatriz(@RequestBody CreateUserAndMatrizRequest request) {
        Client client = clientRepository.save(request.getClient());
        request.getAddress().setClient(client);
        Address address =  addressRepository.save(request.getAddress());
        client.setMatrizAddress(address.getId());
        clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/lookForClient")
    public ResponseEntity <Iterable<Client>> searchClients(
            @RequestParam(name = "identidad", required = false) String identification,
            @RequestParam(name = "nombre", required = false) String name) {

        return ResponseEntity.ok(clientService.searchClients(identification, name));
    }

    @PutMapping("update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {

        return ResponseEntity.ok(clientRepository.save(client));

    }
    @PostMapping("remove")
    public ResponseEntity<Client> removeClient(@RequestBody Client client) {
        addressRepository.findAll().stream().map(address -> {

            if (address.getClient().getId() == client.getId()) {
                addressRepository.delete(address);
            }
            return null;
        });
            clientRepository.delete(client);

        return ResponseEntity.ok(client);

    }

    @PostMapping("/create")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressRepository.save(address));
    }



}
