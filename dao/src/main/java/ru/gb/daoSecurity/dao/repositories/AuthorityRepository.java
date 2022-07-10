package ru.gb.daoSecurity.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.daoSecurity.dao.entities.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

}
