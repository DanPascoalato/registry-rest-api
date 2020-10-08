package br.com.docket.registry.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RegistryOffice {

    private String name;
    private Address address;
    private List<Certificate> certificates;

    public RegistryOffice(String name, Address address, List<Certificate> certificates){
        setName(name);
        setAddress(address);
        this.certificates = new ArrayList<>();
    }

    public RegistryOffice(String name, Address address){
        this(name, address, new ArrayList<>());
    }

    public void addCertificate(Certificate certificate){
        this.certificates.add(certificate);
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
}
