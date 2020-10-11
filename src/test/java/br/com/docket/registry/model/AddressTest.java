package br.com.docket.registry.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    public void whenStreetAddressIsBlankShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Address(1L,"", "","237649", "São Paulo", "SP"));
    }

    @Test
    public void whenPostalCodeIsBlankShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Address(1L, "Av Paulista 1000","","", "São Paulo", "SP"));
    }

    @Test
    public void whenCityIsBlankShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Address(1L, "Av Paulista 1000", "", "237649", "", "SP"));
    }

    @Test
    public void whenStateIsBlankShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Address(1L, "Av Paulista 1000", "", "237649", "São Paulo", ""));
    }

}