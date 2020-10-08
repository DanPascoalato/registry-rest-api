package br.com.docket.registry.repository;

import br.com.docket.registry.model.Address;
import br.com.docket.registry.model.Certificate;
import br.com.docket.registry.model.RegistryOffice;
import org.springframework.data.repository.CrudRepository;

import java.rmi.registry.Registry;
import java.util.List;


public interface RegistryOfficeRepository extends CrudRepository<RegistryOffice, Long> {

    List<RegistryOffice> findByName(String name);

    List<RegistryOffice> findByAddress(Address address);

    List<RegistryOffice> findByCertificate(Certificate certificate);

    RegistryOffice findById (long id);

}
