package br.com.docket.registry.model;

import br.com.docket.registry.repository.CertificateRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @OneToMany
    @JsonProperty("certificates")
    private List<Certificate> certificates;

    private RegistryOffice() {

    }

    public RegistryOffice(String name, Address address, List<Certificate> certificates) {
        setName(name);
        setAddress(address);
        this.certificates = new ArrayList<>();
    }

    public void updateWith(RegistryOffice registryOffice) {
        setName(registryOffice.name);
        Address newAddress = registryOffice.address;
        setAddress(newAddress);
        this.certificates = registryOffice.getCertificates();
    }


//    public void addCertificate(Certificate certificate) {
//        this.certificates.add(certificate);
//    }

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
