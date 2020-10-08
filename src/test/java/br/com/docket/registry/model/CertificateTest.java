package br.com.docket.registry.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import static org.junit.jupiter.api.Assertions.*;

class CertificateTest {

    @Test
    public void whenIdIsNegativeOrZeroShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Certificate(0, "Cert Nascimento"));
    }

    @Test
    public void whenNameIsBlankShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Certificate(1, ""));
    }

    @Test
    public void whenCertificateIsValidShouldReturnInstance() {
        Certificate certificate = new Certificate(1, "Cert Nascimento");
        assertThat(certificate.getId()).isEqualTo(1);
        assertThat(certificate.getName()).isEqualTo("Cert Nascimento");
    }
}