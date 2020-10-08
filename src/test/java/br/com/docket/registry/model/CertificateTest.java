package br.com.docket.registry.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import static org.junit.jupiter.api.Assertions.*;

class CertificateTest {

    @Test
    public void whenIdIsNegativeOrZeroShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Certificate(0L, "Cert Nascimento"));
    }

    @Test
    public void whenNameIsBlankShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Certificate(1L, ""));
    }

    @Test
    public void whenCertificateIsValidShouldReturnInstance() {
        Certificate certificate = new Certificate(1L, "Cert Nascimento");
        assertThat(certificate.getId()).isEqualTo(1);
        assertThat(certificate.getName()).isEqualTo("Cert Nascimento");
    }
}