package br.com.docket.registry.service.stub;

import br.com.docket.registry.model.Certificate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Certidao {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    public Certificate convertToCertificate() {
        return new Certificate(this.getId(), this.getNome());
    }
}
