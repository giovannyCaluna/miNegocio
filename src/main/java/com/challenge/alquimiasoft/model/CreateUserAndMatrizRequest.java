package com.challenge.alquimiasoft.model;

public class CreateUserAndMatrizRequest {
    private Client client;
    private Address address;

    public CreateUserAndMatrizRequest(Client client, Address address) {
        this.client = client;
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public Address getAddress() {
        return address;
    }
}
