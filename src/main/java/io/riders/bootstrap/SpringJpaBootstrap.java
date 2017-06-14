package io.riders.bootstrap;

import io.riders.models.Role;
import io.riders.models.User;
import io.riders.services.HistoryService;
import io.riders.services.RoleService;
import io.riders.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tommy on 5/6/2017.
 */
@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private RoleService roleService;
    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public  void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadRoles();
        loadUsers();
    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role" + adminRole.getRole());
    }

    private void loadUsers() {
        Role userRole = roleService.findByRole("USER");
        Role adminRole = roleService.findByRole("ADMIN");

        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        user1.addRole(userRole);
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        user2.addRole(adminRole);
        userService.saveOrUpdate(user2);

        User user3 = new User();
        user3.setUsername("user2");
        user3.setPassword("user");
        user3.addRole(userRole);
        userService.saveOrUpdate(user3);

        User user4 = new User();
        user4.setUsername("user3");
        user4.setPassword("user");
        user4.addRole(userRole);
        userService.saveOrUpdate(user4);
    }
}
