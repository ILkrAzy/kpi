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
import static org.junit.Assert.assertThat;
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
        User ddlanh = new User();
        ddlanh.setUsername("ddlanh");
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setEmail("test@gmail.com");
        ddlanh.setId(1);

        when(userRepository.findByUsername(ddlanh.getUsername())).thenReturn(ddlanh);
        assertThat(service.getByUsername(ddlanh.getUsername()), equalTo(ddlanh));
    }

    @Test
    public void save() throws Exception {
        User ddlanh = new User();
        ddlanh.setUsername("ddlanh");
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setPassword("123456");
        ddlanh.setEmail("test@gmail.com");
        ddlanh.setId(1);
        service.save(ddlanh);
        verify(userRepository, Mockito.times(1)).save(ddlanh);
        assertThat(ddlanh.getPassword(), equalTo("123456"));
    }
}
