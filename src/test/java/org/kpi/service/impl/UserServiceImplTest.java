package org.kpi.service.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.User;
import org.kpi.repository.UserRepository;
import org.kpi.service.UserService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by lnphi on 7/5/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserService service;
    private User ddlanh;
    private User vqhuy;
    private List<User> users = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl(userRepository);
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
        when(userRepository.findAll()).thenReturn(users);
        assertThat(service.getAll(), equalTo(users));
    }

    @Test
    public void getByUsername() throws Exception {
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
        String username = ddlanh.getUsername();
        when(userRepository.findByUsername(username)).thenReturn(ddlanh);
        assertTrue(service.exist(username));
    }

    @Test
    public void existEmailReturnTrueWhenEmailExist() throws Exception {
        String email = ddlanh.getEmail();
        when(userRepository.findByEmail(email)).thenReturn(ddlanh);
        assertTrue(service.existEmail(email));
    }

    @Test
    public void existEmailReturnFalseWhenEmailDoesNotExist() throws Exception {
        String email = ddlanh.getEmail();
        when(userRepository.findByEmail(email)).thenReturn(null);
        assertFalse(service.existEmail(email));
    }

    @Test
    public void save() throws Exception {
        service.save(ddlanh);
        verify(userRepository, Mockito.times(1)).save(ddlanh);
        assertThat(ddlanh.getPassword(), equalTo("123456"));
    }

    @Test
    public void search() throws Exception {
        when(userRepository.search("Lanh", null, null, null)).thenReturn(users);
        assertThat(service.search("Lanh", null, null, null), equalTo(users));
    }
    
    @Test
    public void searchByFirstNameAndLastName() throws Exception {
        when(userRepository.search("Lanh", "Dan", null, null)).thenReturn(users);
        assertThat(service.search("Lanh", "Dan", null, null), equalTo(users));
    }
    
    @Test
    public void searchByFirstNameAndLastNameAndUserName() throws Exception {
        when(userRepository.search("Lanh", "Dan", "ddlanh", null)).thenReturn(users);
        assertThat(service.search("Lanh", "Dan", "ddlanh", null), equalTo(users));
    }
    
    @Test
    public void searchByEmail() throws Exception {
        when(userRepository.search(null,null, null, "test@")).thenReturn(users);
        assertThat(service.search(null, null, null, "test@"), equalTo(users));
    }
}
