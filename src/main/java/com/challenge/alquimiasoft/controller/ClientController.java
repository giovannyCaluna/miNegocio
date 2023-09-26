package com.challenge.alquimiasoft.controller;

import com.challenge.alquimiasoft.IRepository.IAddressRepository;
import com.challenge.alquimiasoft.IRepository.IClientRepository;
import com.challenge.alquimiasoft.model.Address;
import com.challenge.alquimiasoft.model.Client;
import com.challenge.alquimiasoft.pojo.ClientRequest;
import com.challenge.alquimiasoft.pojo.CreateUserAndMatrizRequest;
import com.challenge.alquimiasoft.pojo.UserIdentificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {


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
        List<Address> response2 = (List<Address>) addressRepository.findByClientId(id);
        return ResponseEntity.ok(response2);

    }

    @PostMapping("createClient")
    public ResponseEntity<Client> createClient(@RequestBody ClientRequest client) {
        Client newClient = new Client(client.getIdentificationType(),
                client.getIdentificationNumber(),
                client.getName(),
                client.getEmail(),
                client.getCellphone(),
                client.getMatriz_address_id());
        return ResponseEntity.ok(clientRepository.save(newClient));
    }

    @PostMapping("createClientAndMatriz")
    public ResponseEntity<Client> createClientandMatriz(@RequestBody CreateUserAndMatrizRequest request) {
        Client client = clientRepository.save(request.getClient());
        request.getAddress().setClient(client);
        Address address = addressRepository.save(request.getAddress());
        client.setMatrizAddress(address.getId());
        clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/lookForClient")
    public ResponseEntity<List<Client>> searchClients(@RequestBody UserIdentificationRequest request) {

        if (request.getName() != "" && request.getIdentification() != "") {
            return ResponseEntity.ok(clientRepository.findBynameOrIdentification(request.getName(), request.getIdentification()));

        }
        if (request.getName() != null && request.getName() != "") {
            return ResponseEntity.ok(clientRepository.findByname(request.getName()));

        }
        if (request.getIdentification() != null && request.getIdentification() != "") {
            return ResponseEntity.ok(clientRepository.findByIdentification(request.getIdentification()));
        }

        return null;
    }

    @PostMapping("update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {

        return ResponseEntity.ok(clientRepository.save(client));

    }

    @PostMapping("remove")
    public ResponseEntity<Client> removeClient(@RequestBody Client client) {
        addressRepository.deleteAll(addressRepository.findByClientId(client.getId()));
        clientRepository.delete(client);
        return ResponseEntity.ok(client);

    }

    @PostMapping("/create")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressRepository.save(address));
    }


}
