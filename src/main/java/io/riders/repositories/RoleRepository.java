package io.riders.repositories;

import io.riders.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Database repository for Roles
 */
public interface RoleRepository extends CrudRepository<Role, Integer>{
    Role findByRole(String role);
}