package io.riders;

import io.riders.models.Role;
import io.riders.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by mruga on 17.05.2017.
 */
public class UserTest {
    @Test
    public void testUserUsername(){
        User user = new User();
        String username = "test123";
        user.setUsername(username);
        assertEquals( username, user.getUsername());

    }
    @Test
    public void testUserEnabled(){
        User user = new User();
        user.setEnabled(true);
        assertEquals(true, user.getEnabled());

    }

    @Test
    public void testUserDisabled(){
        User user = new User();
        user.setEnabled(false);
        assertEquals(false, user.getEnabled());

    }

    @Test
    public void testUserSetRoles(){
        User user = new User();
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setRole("role");
        roles.add(role);
        user.setRoles(roles);
        assertThat(roles, is(user.getRoles()));
    }


    @Test
    public void testUserAddRole(){
        User user = new User();
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setRole("role");
        user.addRole(role);
        roles.add(role);
        assertThat(roles, is(user.getRoles()));
    }

    @Test
    public void testUserRemoveRole(){
        User user = new User();
        List<Role> roles = new ArrayList<>();
        Role role1 = new Role();
        role1.setRole("role1");
        Role role2 = new Role();
        role2.setRole("role2");
        roles.add(role1);
        roles.add(role2);
        user.setRoles(roles);
        roles.remove(role2);
        user.removeRole(role2);
        assertThat(roles, is(user.getRoles()));
    }

    @Test
    public void testUserPassword(){
        User user = new User();
        String pass = "pass321";
        user.setPassword(pass);
        assertEquals(pass, user.getPassword());

    }

    @Test
    public void testMultipleUserRole(){
        User user = new User();
        Role role = new Role();
        List<Role> roles = new ArrayList<>();
        role.setRole("role");
        roles.add(role);
        user.addRole(role);
        user.addRole(role);
        user.addRole(role);
        assertThat(roles,is(user.getRoles()));
    }

}
