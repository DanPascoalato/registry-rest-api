package br.com.docket.registry.repository;

import br.com.docket.registry.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional(value = Transactional.TxType.MANDATORY)
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

}