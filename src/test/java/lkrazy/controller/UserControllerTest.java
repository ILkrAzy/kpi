package lkrazy.controller;

import lkrazy.pojo.User;
import lkrazy.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
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
        controller = new UserController(userRepository);
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = new ArrayList<>();
        User ddlanh = new User();
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setEmail("test@gmail.com");

        User vqhuy = new User();
        vqhuy.setFirstName("Huy");
        vqhuy.setLastName("Vu");
        vqhuy.setEmail("test@gmail.com");

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

        when(userRepository.findByUsername(ddlanh.getUsername())).thenReturn(Arrays.asList(ddlanh));
        assertThat(controller.getByUsername(ddlanh.getUsername()), equalTo(ddlanh));
    }

    @Test
    public void create() throws Exception {
        User ddlanh = new User();
        ddlanh.setUsername("ddlanh");
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setEmail("test@gmail.com");
        controller.create(ddlanh);
        verify(userRepository, Mockito.times(1)).save(ddlanh);
    }
}
