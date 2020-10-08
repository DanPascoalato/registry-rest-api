package br.com.docket.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "address")
public class Address {

    @Column(name = "streetAddress")
    @JsonProperty("street")
    private String streetAddress;

    @Column(name = "postal_code")
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
