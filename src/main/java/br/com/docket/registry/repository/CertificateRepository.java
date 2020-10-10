package br.com.docket.registry.repository;

import br.com.docket.registry.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional(value = Transactional.TxType.MANDATORY)
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    public Optional<Certificate> findByName(String certificateName);

}