package io.riders.services;

import io.riders.models.User;
import io.riders.repositories.UserRepository;
import io.riders.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 5/5/2017.
 */

/**
 * Service users persistence
 */
@Service
@Profile("springdatajpa")
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    /**
     * Lists all saved users
     * @return
     */
    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    /**
     * Finds a user with given id
     * @param id
     * @return
     */
    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    /**
     * Saves given user
     * @param domainObject
     * @return
     */
    @Override
    public User saveOrUpdate(User domainObject) {
        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        return userRepository.save(domainObject);
    }

    /**
     * Deletes a user with given id
     * @param id
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    /**
     * Finds a user with given name
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
