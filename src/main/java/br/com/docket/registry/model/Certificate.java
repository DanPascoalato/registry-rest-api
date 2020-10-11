package br.com.docket.registry.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cert_gen_seq")
    @JsonProperty("id")
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    private Certificate() { }

    public Certificate(Long id, String name) {
        setId(id);
        setName(name);
    }

    private void setId(Long id) {
        if(id <= 0){
            throw new IllegalArgumentException("Certificate Id must be must greater than 0");
        }
        this.id = id;
    }

    private void setName(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException("Certificate Name cannot be null or empty");
        }
        this.name = name.trim();
    }
}