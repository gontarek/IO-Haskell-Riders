package io.riders.repositories;

import io.riders.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tommy on 5/5/2017.
 */
public interface RoleRepository extends CrudRepository<Role, Integer>{
}