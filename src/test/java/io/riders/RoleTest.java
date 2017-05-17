package io.riders;

import io.riders.models.Role;
import io.riders.models.User;
import org.junit.Test;

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
}
