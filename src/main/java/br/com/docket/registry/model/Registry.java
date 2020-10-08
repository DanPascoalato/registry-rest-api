package br.com.docket.registry.model;

import lombok.Getter;

@Getter
public class Registry {

    private String name;
    private Address address;
    private Certificate certificate;

    public Registry(String name, Address address, Certificate certificate){
        setName(name);
        setAddress(address);
        setCertificate(certificate);
    }

    private void setName(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException();
        }
        this.name = name.trim();
    }

    private void setAddress(Address address) {
        if(address == null){
            throw new IllegalArgumentException();
        }
        this.address = address;
    }

    private void setCertificate(Certificate certificate) {
        if(certificate == null){
            throw new IllegalArgumentException();
        }
        this.certificate = certificate;
    }
}
