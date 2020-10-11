package br.com.docket.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class RegistryOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "regis_gen_seq")
    @JsonProperty
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @OneToOne
    @JsonProperty("address")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("certificates")
    private List<Certificate> certificates;

    private RegistryOffice() { }

    public RegistryOffice(Long id, String name, Address address, List<Certificate> certificates) {
        setId(id);
        setName(name);
        setAddress(address);
        setCertificates(certificates);
    }

    private void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Office ID must be greater than 0");
        }
        this.id = id;
    }

    private void setName(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException("Office Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    private void setAddress(Address address) {
        if(address == null){
            throw new IllegalArgumentException("Office address cannot be null or empty");
        }
        this.address = address;
    }

    private void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
