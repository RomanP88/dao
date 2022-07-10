package ru.gb.daoSecurity.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.daoSecurity.dao.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
