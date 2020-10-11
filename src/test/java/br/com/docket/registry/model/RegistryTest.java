package br.com.docket.registry.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RegistryTest {

    private Address address = new Address(1L,"Av Paulista 1000","123", "234524", "São Paulo", "SP");
    private List<Certificate> certs = List.of(new Certificate(1L, "Certi de Nascimento"));

    @Test
    public void whenNameIsBlankShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new RegistryOffice(1L, "", address, certs));
    }

    @Test
    public void whenAddressIsNullShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new RegistryOffice(1L, "Cartorio de notas", null, certs));
    }

    //TODO implement test if it works

}