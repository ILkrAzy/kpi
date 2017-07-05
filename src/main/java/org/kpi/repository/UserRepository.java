package org.kpi.repository;

import org.kpi.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findByUsername(String username);
}
