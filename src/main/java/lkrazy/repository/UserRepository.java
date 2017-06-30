package lkrazy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lkrazy.pojo.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findByUsername(String username);
}
