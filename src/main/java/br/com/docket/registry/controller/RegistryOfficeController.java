package br.com.docket.registry.controller;


import br.com.docket.registry.model.RegistryOffice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registry")
public class RegistryOfficeController {

    @PostMapping("/add")
    public RegistryOffice save(@RequestBody RegistryOffice registryOffice) {
        return registryOffice;
    }


}
