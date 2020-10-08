package br.com.docket.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Address {

    @JsonProperty("street")
    private String streetAddress;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("city")
    private String city;
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
