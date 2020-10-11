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

    @Column(name = "streetName")
    @JsonProperty("streetName")
    private String streetAddress;

    @Column(name = "streetNumber")
    @JsonProperty("streetNumber")
    private String number;

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

    public Address(Long id, String streetAddress, String number, String postalCode, String city, String state) {
        setId(id);
        setStreetAddress(streetAddress);
        setNumber(number);
        setPostalCode(postalCode);
        setCity(city);
        setState(state);
    }

    public Address updateWith(Address addr) {
        setStreetAddress(addr.getStreetAddress());
        setPostalCode(addr.getPostalCode());
        setCity(addr.getCity());
        setState(addr.getState());
        setNumber(addr.getNumber());
        return this;
    }


    private void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    private void setStreetAddress(String streetAddress) {
        if (streetAddress == null || streetAddress.isBlank()) {
            throw new IllegalArgumentException("Street Address cannot be null or empty");
        }
        this.streetAddress = streetAddress.trim();
    }

    private void setNumber(String number) {
        if (number == null || number.isBlank()) {
            this.number = "SN";
        } else {
            this.number = number;
        }
    }

    private void setPostalCode(String postalCode) {
        if (postalCode == null || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal Code cannot be null or empty");
        }
        this.postalCode = postalCode.trim();
    }

    private void setCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city.trim();
    }

    private void setState(String state) {
        if (state == null || state.isBlank()) {
            throw new IllegalArgumentException("State cannot be null or empty");
        }
        this.state = state.trim();
    }

}
