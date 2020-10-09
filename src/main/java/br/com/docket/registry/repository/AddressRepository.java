package br.com.docket.registry.repository;


import br.com.docket.registry.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(value = Transactional.TxType.MANDATORY)
public interface AddressRepository extends CrudRepository<Address, Long> {

}
