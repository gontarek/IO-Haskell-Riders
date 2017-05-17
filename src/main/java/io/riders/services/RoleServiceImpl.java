package io.riders.services;

import io.riders.models.Role;
import io.riders.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 5/5/2017.
 */

/**
 * Service for roles persistence
 */
@Service
@Profile("springdatajpa")
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Lists all saved roles
     * @return
     */
    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    /**
     * Finds a role with given id
     * @param id
     * @return
     */
    @Override
    public Role getById(Integer id) {
        return roleRepository.findOne(id);
    }

    /**
     * Saves given role
     * @param domainObject
     * @return
     */
    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepository.save(domainObject);
    }

    /**
     * Deletes a role with given id
     * @param id
     */
    @Override
    public void delete(Integer id) {
        roleRepository.delete(id);
    }
}
