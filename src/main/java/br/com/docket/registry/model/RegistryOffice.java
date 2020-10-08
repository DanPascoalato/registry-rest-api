package br.com.docket.registry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RegistryOffice {

    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private Address address;
    @JsonIgnore
    private List<Certificate> certificates;

    private RegistryOffice() {

    }

    public RegistryOffice(String name, Address address, List<Certificate> certificates) {
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
