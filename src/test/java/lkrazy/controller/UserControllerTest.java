package lkrazy.controller;

import lkrazy.pojo.User;
import lkrazy.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lnphi on 7/4/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    private UserController controller;

    @Before
    public void setUp() throws Exception {
        controller = new UserController(userRepository, new BCryptPasswordEncoder());
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = new ArrayList<>();
        User ddlanh = new User();
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setEmail("test@gmail.com");
        ddlanh.setId(1);
        ddlanh.setRole(1);

        User vqhuy = new User();
        vqhuy.setFirstName("Huy");
        vqhuy.setLastName("Vu");
        vqhuy.setEmail("test@gmail.com");
        vqhuy.setId(2);
        vqhuy.setRole(1);

        users.add(ddlanh);
        users.add(vqhuy);

        when(userRepository.findAll()).thenReturn(users);
        assertThat(controller.getAll(), equalTo(users));
    }

    @Test
    public void getByUsername() throws Exception {
        User ddlanh = new User();
        ddlanh.setUsername("ddlanh");
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setEmail("test@gmail.com");
        ddlanh.setId(1);
        ddlanh.setRole(1);

        when(userRepository.findByUsername(ddlanh.getUsername())).thenReturn(Arrays.asList(ddlanh));
        assertThat(controller.getByUsername(ddlanh.getUsername()), equalTo(ddlanh));
    }

    @Test
    public void create() throws Exception {
        User ddlanh = new User();
        ddlanh.setUsername("ddlanh");
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setPassword("123456");
        ddlanh.setEmail("test@gmail.com");
        ddlanh.setId(1);
        ddlanh.setRole(1);
        controller.create(ddlanh);
        verify(userRepository, Mockito.times(1)).save(ddlanh);
        assertThat(ddlanh.getPassword(), not(equalTo("123456")));
    }
}
