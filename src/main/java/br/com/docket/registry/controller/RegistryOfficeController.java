package br.com.docket.registry.controller;


import br.com.docket.registry.model.Address;
import br.com.docket.registry.model.Certificate;
import br.com.docket.registry.model.RegistryOffice;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/registry")
public class RegistryOfficeController {

    @PostMapping
    public RegistryOffice save(@RequestBody RegistryOffice registryOffice) {
        return registryOffice;
    }

    @GetMapping("/{id}")
    public RegistryOffice get(@PathVariable("id") Long id) {
        Address address = new Address("Av Paulista 1000", "234524", "São Paulo", "SP");
        List<Certificate> certs = List.of(new Certificate( 1L, "Certi de Nascimento"));
        return new RegistryOffice("Casa da mãe Joana", address, certs);
    }

    @PutMapping("/{id}")
    public RegistryOffice put(@RequestBody RegistryOffice registryOffice, @PathVariable("id") Long id) {
        Address address = new Address("Av Paulista 1000", "234524", "São Paulo", "SP");
        List<Certificate> certs = List.of(new Certificate( 1L, "Certi de Nascimento"));
        return new RegistryOffice("Casa do João", address, certs);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable("id") Long id) {
    }

    @GetMapping
    public List<RegistryOffice> list() {
        return new ArrayList<>();
    }
}
