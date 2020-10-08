package br.com.docket.registry.model;

import lombok.Getter;

@Getter
public class Certificate {

    private Integer id;
    private String name;

    public Certificate(Integer id, String name){
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