package org.kpi.repository;

import java.util.List;

import org.kpi.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    public List<Role> findByName(String name);
}
