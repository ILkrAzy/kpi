package org.kpi.repository;

import org.kpi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    @Query("select u from User u where  u.firstName like ?1% or u.lastName like ?2% or u.username like ?3% or u.email like ?4%")
    List<User> search(String firstname, String lastname, String username, String email);
}
