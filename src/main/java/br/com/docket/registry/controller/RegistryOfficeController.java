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
    public RegistryOffice put(@RequestBody RegistryOffice newRegistryOffice, @PathVariable("id") Long id) {
        Optional<RegistryOffice> optionalOffice = officeRepo.findById(id);
        if(optionalOffice.isPresent()) {
            RegistryOffice office = optionalOffice.orElse(null);
            Address savedAddress = addressRepo.save(newRegistryOffice.getAddress());
            newRegistryOffice.getCertificates().forEach(cert -> certRepo.save(cert));
            office.updateWith(newRegistryOffice);
            return officeRepo.save(office);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> del(@PathVariable("id") Long id) {
        return officeRepo.findById(id)
                .map(registryOffice -> {
                    officeRepo.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<RegistryOffice> list() {
        return (List<RegistryOffice>) officeRepo.findAll();
    }


}
