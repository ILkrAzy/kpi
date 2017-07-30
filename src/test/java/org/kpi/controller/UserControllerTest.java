package org.kpi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.User;
import org.kpi.model.dto.NewUser;
import org.kpi.service.UserService;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by lnphi on 7/4/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController controller;
    private User ddlanh;
    private User vqhuy;
    private List<User> users = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        controller = new UserController(userService, new BCryptPasswordEncoder());
        ddlanh = new User();
        ddlanh.setUsername("ddlanh");
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setEmail("test@gmail.com");
        ddlanh.setPassword("123456");
        ddlanh.setId(1);

        vqhuy = new User();
        vqhuy.setUsername("vqhuy");
        vqhuy.setFirstName("Huy");
        vqhuy.setLastName("Vu");
        vqhuy.setEmail("test@gmail.com");
        vqhuy.setPassword("123456");
        vqhuy.setId(2);

        users.add(ddlanh);
        users.add(vqhuy);
    }

    @Test
    public void getAll() throws Exception {
        when(userService.search(null, null, null, null)).thenReturn(users);
        List<NewUser> newUsers = NewUser.toList(users);
        assertThat(controller.search(null, null, null, null, null), equalTo(ResponseEntity.ok(newUsers)));
    }

    @Test
    public void getByUsername() throws Exception {
        when(userService.getByUsername(ddlanh.getUsername())).thenReturn(ddlanh);
        NewUser newUser = NewUser.fromModel(ddlanh);
        assertThat(controller.getByUsername(ddlanh.getUsername()), equalTo(ResponseEntity.ok(newUser)));
    }

    @Test
    public void getReturn404WhenUserDoesNotExist() throws Exception {
        String username = "ddlanh";
        when(userService.getByUsername(username)).thenReturn(null);
        assertThat(controller.getByUsername(username), equalTo(ResponseEntity.notFound().build()));
    }

    @Test
    public void create() throws Exception {
        NewUser ddlanh = new NewUser();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        ddlanh.setUsername("ddlanh");
        ddlanh.setFirstName("Lanh");
        ddlanh.setLastName("Dang");
        ddlanh.setPassword("123456");
        ddlanh.setEmail("test@gmail.com");
        controller.create(ddlanh);
        User dbModel = ddlanh.toModel(passwordEncoder);
        verify(userService, times(1)).save(dbModel);
        assertThat(dbModel.getPassword(), not(equalTo("123456")));
    }
    
    @Test
    public void searchByFirstName() throws Exception {
        when(userService.search("Lanh", null, null, null)).thenReturn(users);
        List<NewUser> newUsers = NewUser.toList(users);
        assertThat(controller.search("Lanh", null, null, null, null), equalTo(ResponseEntity.ok(newUsers)));
    }
    
    @Test
    public void searchByFirstNameAndLastName() throws Exception {
        when(userService.search("Lanh", "Dan%", null, null)).thenReturn(users);
        List<NewUser> newUsers = NewUser.toList(users);
        assertThat(controller.search("Lanh", "Dan%", null, null, null), equalTo(ResponseEntity.ok(newUsers)));
    }
    
    @Test
    public void searchByFirstNameAndLastNameAndEmail() throws Exception {
        when(userService.search("Lanh", "Dang", null, "test@%")).thenReturn(users);
        List<NewUser> newUsers = NewUser.toList(users);
        assertThat(controller.search("Lanh", "Dang", null, "test@%", null), equalTo(ResponseEntity.ok(newUsers)));
    }

    @Test
    public void searchReturn404WhenUserDoesNotExist() throws Exception {
        String username = "notfound";
        when(userService.searchEverything(username)).thenReturn(null);
        assertThat(controller.search(null, null, null, null, username), equalTo(ResponseEntity.notFound().build()));
    }
}
