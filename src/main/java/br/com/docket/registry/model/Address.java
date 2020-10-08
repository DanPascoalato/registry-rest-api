package br.com.docket.registry.model;

import lombok.Getter;

@Getter
public class Address {

    private String streetAddress;
    private String postalCode;
    private String city;
    private String state;

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
