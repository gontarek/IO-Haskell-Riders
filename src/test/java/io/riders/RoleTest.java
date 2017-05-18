package io.riders;

import io.riders.models.Role;
import io.riders.models.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by mruga on 17.05.2017.
 */
public class RoleTest {
    @Test
    public void testRoleSetRole(){
        Role role = new Role();
        String roleStr = "test123";
        role.setRole(roleStr);
        assertEquals(role.getRole(),roleStr);
    }
    @Test
    public void  testRoleAddUser(){
        Role role = new Role();
        User user = new User();
        role.addUser(user);
        assertThat(role.getUsers().contains(user));

    }
    @Test
    public void testRoleSetUsers(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        users.add(user1);
        users.add(user2);
        Role role = new Role();
        role.addUser(user1);
        role.addUser(user2);
        assertEquals(role.getUsers(), users);

    }
    @Test
    public void testRoleRemoveUser(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        users.add(user1);
        users.add(user2);
        Role role = new Role();
        role.addUser(user1);
        role.addUser(user2);
        role.removeUser(user2);
        users.remove(user2);
        assertEquals(role.getUsers(), users);

    }
}
