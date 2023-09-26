package com.challenge.alquimiasoft.pojo;

public class ClientRequest {

    private String identificationType;

    private String identificationNumber;

    private String name;

    private String email;

    private String cellphone;

    private Long matriz_address_id;

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

    public Long getMatriz_address_id() {
        return matriz_address_id;
    }

    public void setMatriz_address_id(Long matriz_address_id) {
        this.matriz_address_id = matriz_address_id;
    }
}
