package io.riders.services;

import io.riders.models.Role;
import io.riders.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 5/5/2017.
 */
public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.delete(id);
    }
}