package projeto7.spring.data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto7.spring.data.model.Telefone;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {

}
