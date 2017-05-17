package io.riders;

import io.riders.models.Role;
import io.riders.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tommy on 5/18/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserToUserDetailsTests {

    User mockUser = Mockito.mock(User.class);
    private Converter<User, UserDetails> userUserDetailsConverter;

    @Autowired
    @Qualifier(value = "userToUserDetails")
    public void setUserUserDetailsConverter(Converter<User, UserDetails> userUserDetailsConverter) {
        this.userUserDetailsConverter = userUserDetailsConverter;
    }

    @Test
    public void testUserToUserDetailsConverting() {
        when(mockUser.getUsername()).thenReturn("user");
        when(mockUser.getEncryptedPassword()).thenReturn("encryptedPassword");
        when(mockUser.getEnabled()).thenReturn(true);
        when(mockUser.getRoles()).thenReturn(new ArrayList<Role>());

        UserDetails userDetails = this.userUserDetailsConverter.convert(mockUser);

        assertEquals(userDetails.getUsername(), "user");
        assertEquals(userDetails.getPassword(), "encryptedPassword");
        assertEquals(userDetails.isEnabled(), true);
        assertTrue(userDetails.getAuthorities().isEmpty());

        verify(mockUser).getUsername();
        verify(mockUser).getEncryptedPassword();
        verify(mockUser).getEnabled();
        verify(mockUser).getRoles();
    }


}
