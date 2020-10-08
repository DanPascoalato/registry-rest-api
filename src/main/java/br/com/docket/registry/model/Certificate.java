package br.com.docket.registry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Certificate {

    @JsonIgnore
    private Integer id;
    @JsonProperty("name")
    private String name;

    private Certificate() {

    }

    public Certificate(Integer id, String name) {
        setId(id);
        setName(name);
    }

    private void setId(Integer id) {
        if(id <= 0){
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    private void setName(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException();
        }
        this.name = name.trim();
    }
}