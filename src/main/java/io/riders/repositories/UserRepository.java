package io.riders.repositories;

import io.riders.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for users
 */
public interface UserRepository extends CrudRepository<User, Integer>{

    /**
     * Finds a user in the database by username (username is unique in db)
     * @param username self-descriptory
     * @return User with given username
     */
    User findByUsername(String username);
}
