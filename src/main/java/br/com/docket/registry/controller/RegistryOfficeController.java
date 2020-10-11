package br.com.docket.registry.controller;


import br.com.docket.registry.model.Address;
import br.com.docket.registry.model.Certificate;
import br.com.docket.registry.model.RegistryOffice;
import br.com.docket.registry.repository.AddressRepository;
import br.com.docket.registry.repository.CertificateRepository;
import br.com.docket.registry.repository.RegistryOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/registry")
@Transactional
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
    public ResponseEntity<RegistryOffice> save(@RequestBody RegistryOffice registryOffice) {
        registryOffice.getCertificates().forEach(cert -> certRepo.saveAndFlush(cert));
        Address savedAddress = addressRepo.saveAndFlush(registryOffice.getAddress());
        RegistryOffice savedRegistryOffice = officeRepo.saveAndFlush(registryOffice);
        return new ResponseEntity<>(savedRegistryOffice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistryOffice> get(@PathVariable("id") Long id) {
        Optional<RegistryOffice> foundRegistryOffice = officeRepo.findById(id);
        return ResponseEntity.of(foundRegistryOffice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistryOffice> put(@PathVariable("id") Long id,
                                              @RequestBody RegistryOffice updatingOffice) {
        Optional<RegistryOffice> foundRegistryOffice = officeRepo.findById(id);
        Optional<RegistryOffice> updatedRegistryOffice = foundRegistryOffice.map(off -> {
            Address address = addressRepo.save(off.getAddress().updateWith(updatingOffice.getAddress()));
            certRepo.deleteAll(off.getCertificates());
            List<Certificate> certificates = certRepo.saveAll(updatingOffice.getCertificates());
            RegistryOffice office = new RegistryOffice(off.getId(), updatingOffice.getName(), address, certificates);
            return officeRepo.saveAndFlush(office);
        });

        return ResponseEntity.of(updatedRegistryOffice);
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
