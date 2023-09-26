package com.challenge.alquimiasoft.model;
import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificationType;

    private String identificationNumber;

    private String name;

    private String email;

    private String cellphone;

    private Long matriz_address_id;
    public Client() {
    }

    public Client(String identificationType, String identificationNumber, String name, String email, String cellphone, Long matrizAddress) {
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.matriz_address_id = matrizAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Long getMatrizAddress() {
        return matriz_address_id;
    }

    public void setMatrizAddress(Long matrizAddress) {
        this.matriz_address_id = matrizAddress;
    }
}