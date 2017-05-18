package io.riders;

import io.riders.models.User;
import io.riders.repositories.UserRepository;
import io.riders.services.UserService;
import io.riders.services.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tommy on 5/18/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @InjectMocks
    UserService userService = new UserServiceImpl();

    @Mock
    UserRepository userRepository;

    @Test
    public void testGetById() {
        User user = mock(User.class);
        when(userRepository.findOne(1)).thenReturn(user);

        User fetchedUser = userService.getById(1);
        assertTrue(user == fetchedUser);

        verify(userRepository).findOne(1);
    }

    @Test
    public void testFindByUsername() {
        User user = mock(User.class);
        when(userRepository.findByUsername("user")).thenReturn(user);

        User fetchedUser = userService.findByUsername("user");
        assertTrue(fetchedUser == user);

        verify(userRepository).findByUsername("user");
    }

    @Test
    public void testSaveOrUpdate() {
        User user = mock(User.class);
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveOrUpdate(user);
        assertTrue(savedUser == user);

        verify(userRepository).save(user);
    }

}
