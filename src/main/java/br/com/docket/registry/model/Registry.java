package br.com.docket.registry.model;

import lombok.Getter;

@Getter
public class Registry {

    public Registry(){

    }

    private String name;
    private Address address;
    private Certificate certificate;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}
