package lkrazy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lkrazy.pojo.User;

@Repository
@Component
public interface UserRepository extends CrudRepository<User, Long>{

}
