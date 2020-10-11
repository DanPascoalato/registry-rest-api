package br.com.docket.registry.controller;


import br.com.docket.registry.model.Certificate;
import br.com.docket.registry.service.DocketCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/certificates")
public class CertificateController {

    DocketCertificateService service;

    @Autowired
    public CertificateController(DocketCertificateService service) {
        this.service = service;
    }

    @GetMapping
    public List<Certificate> getCertificates() throws IOException {
        return service.fetchCertificates();
    }

}
