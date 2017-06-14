package io.riders.services;

import io.riders.models.Role;

/**
 * Created by tommy on 5/5/2017.
 */
public interface RoleService extends CRUDService<Role>{

    Role findByRole(String role);

}
