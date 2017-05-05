package io.riders.repositories;

import io.riders.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tommy on 5/5/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);
}
