package br.com.docket.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "address_gen_seq")
    @JsonProperty
    private Long id;

    @Column(name = "streetAddress")
    @JsonProperty("street")
    private String streetAddress;

    @Column(name = "postalCode")
    @JsonProperty("postalCode")
    private String postalCode;

    @Column(name = "city")
    @JsonProperty("city")
    private String city;

    @Column(name = "state")
    @JsonProperty("state")
    private String state;

    private Address() {

    }

    public Address(String streetAddress, String postalCode, String city, String state){
        setStreetAddress(streetAddress);
        setPostalCode(postalCode);
        setCity(city);
        setState(state);
    }

    private void setStreetAddress(String streetAddress) {
        if(streetAddress.isBlank()){
            throw new IllegalArgumentException();
        }
        this.streetAddress = streetAddress.trim();
    }

    private void setPostalCode(String postalCode) {
        if(postalCode.isBlank()){
            throw new IllegalArgumentException();
        }
        this.postalCode = postalCode.trim();
    }

    private void setCity(String city) {
        if(city.isBlank()){
            throw new IllegalArgumentException();
        }
        this.city = city.trim();
    }

    private void setState(String state) {
        if(state.isBlank()){
            throw new IllegalArgumentException();
        }
        this.state = state.trim();
    }


}
