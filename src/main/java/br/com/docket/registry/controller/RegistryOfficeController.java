package br.com.docket.registry.controller;


import br.com.docket.registry.model.Address;
import br.com.docket.registry.model.Certificate;
import br.com.docket.registry.model.RegistryOffice;
import br.com.docket.registry.repository.AddressRepository;
import br.com.docket.registry.repository.CertificateRepository;
import br.com.docket.registry.repository.RegistryOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/registry")
public class RegistryOfficeController {

    private RegistryOfficeRepository officeRepo;
    private AddressRepository addressRepo;
    private CertificateRepository certRepo;

    @Autowired
    public RegistryOfficeController(RegistryOfficeRepository officeRepo,
                                    AddressRepository addressRepo,
                                    CertificateRepository certRepo) {
        this.officeRepo = officeRepo;
        this.addressRepo = addressRepo;
        this.certRepo = certRepo;
    }


    @PostMapping
    public RegistryOffice save(@RequestBody RegistryOffice registryOffice) {
        registryOffice.getCertificates().forEach(cert -> certRepo.save(cert));
        Address savedAddress = addressRepo.save(registryOffice.getAddress());
        return officeRepo.save(registryOffice);
    }

    @GetMapping("/{id}")
    public RegistryOffice get(@PathVariable("id") Long id) {
        Optional<RegistryOffice> office = officeRepo.findById(id);
        return office.orElse(null);
    }

    @PutMapping("/{id}")
    public RegistryOffice put(@RequestBody RegistryOffice registryOffice, @PathVariable("id") Long id) {
        Address address = new Address("Av Paulista 1000", "234524", "São Paulo", "SP");
        List<Certificate> certs = List.of(new Certificate( 1L, "Certi de Nascimento"));
        return new RegistryOffice("Casa do João", address, certs);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable("id") Long id) {
        officeRepo.deleteById(id);
    }

    @GetMapping
    public List<RegistryOffice> list() {
        return (List<RegistryOffice>) officeRepo.findAll();
    }


}
