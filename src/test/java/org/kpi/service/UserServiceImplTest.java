package org.kpi.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.User;
import org.kpi.repository.UserRepository;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lnphi on 7/5/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserService service;

    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl(userRepository);
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = new ArrayList<>();
        User ddlanh = new User();
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setEmail("test@gmail.com");
        ddlanh.setId(1);

        User vqhuy = new User();
        vqhuy.setFirstName("Huy");
        vqhuy.setLastName("Vu");
        vqhuy.setEmail("test@gmail.com");
        vqhuy.setId(2);

        users.add(ddlanh);
        users.add(vqhuy);

        when(userRepository.findAll()).thenReturn(users);
        assertThat(service.getAll(), equalTo(users));
    }

    @Test
    public void getByUsername() throws Exception {
        User ddlanh = getSampleUser();

        when(userRepository.findByUsername(ddlanh.getUsername())).thenReturn(ddlanh);
        assertThat(service.getByUsername(ddlanh.getUsername()), equalTo(ddlanh));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByUsernameShouldThrowExceptionWhenUsernameDoesNotExist() throws Exception {
        String username = "username";
        when(userRepository.findByUsername(username)).thenReturn(null);
        service.getByUsername(username);
    }

    @Test
    public void existReturnFalseWhenUsernameDoesNotExist() throws Exception {
        String username = "username";
        when(userRepository.findByUsername(username)).thenReturn(null);
        assertFalse(service.exist(username));
    }

    @Test
    public void existReturnTrueWhenUsernameExist() throws Exception {
        User ddlanh = getSampleUser();
        String username = ddlanh.getUsername();
        when(userRepository.findByUsername(username)).thenReturn(ddlanh);
        assertTrue(service.exist(username));
    }

    @Test
    public void existEmailReturnTrueWhenEmailExist() throws Exception {
        User ddlanh = getSampleUser();
        String email = ddlanh.getEmail();
        when(userRepository.findByEmail(email)).thenReturn(ddlanh);
        assertTrue(service.existEmail(email));
    }

    @Test
    public void existEmailReturnFalseWhenEmailDoesNotExist() throws Exception {
        User ddlanh = getSampleUser();
        String email = ddlanh.getEmail();
        when(userRepository.findByEmail(email)).thenReturn(null);
        assertFalse(service.existEmail(email));
    }

    @Test
    public void save() throws Exception {
        User ddlanh = getSampleUser();
        service.save(ddlanh);
        verify(userRepository, Mockito.times(1)).save(ddlanh);
        assertThat(ddlanh.getPassword(), equalTo("123456"));
    }

    private User getSampleUser() {
        User user = new User();
        user.setUsername("ddlanh");
        user.setFirstName("Lanh");
        user.setLastName("Dang");
        user.setPassword("123456");
        user.setEmail("test@gmail.com");
        user.setId(1);
        return user;
    }
}
