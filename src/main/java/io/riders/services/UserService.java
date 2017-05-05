package io.riders.services;

import io.riders.models.User;

/**
 * Created by tommy on 5/5/2017.
 */
public interface UserService extends CRUDService<User>{
    User findByUsername(String username);
}
