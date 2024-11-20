package br.com.kauanlp.spring_sec_jwt.repository;

import br.com.kauanlp.spring_sec_jwt.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}
