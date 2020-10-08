package br.com.docket.registry.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RegistryTest {

    private Address address = new Address("Av Paulista 1000", "234524", "São Paulo", "SP");
    private Certificate cert = new Certificate(1, "Certi de Nascimento");

    @Test
    public void whenNameIsBlankShouldThrowIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(()-> new Registry("", address, cert));
    }

    @Test
    public void whenAddressIsNullShouldThrowIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(()-> new Registry("Cartorio de notas", null, cert));
    }

    @Test
    public void whenCertificateIsNullShouldThrowIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(()-> new Registry("Cartorio de notas", address, null));
    }

    //TODO implement test if it works

}