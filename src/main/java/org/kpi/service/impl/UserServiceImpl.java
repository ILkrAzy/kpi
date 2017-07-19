package org.kpi.service.impl;

import org.kpi.model.User;
import org.kpi.repository.UserRepository;
import org.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by lnphi on 7/5/2017.
 */
@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean exist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public boolean existEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public List<User> search(String firstName, String lastName, String userName, String email) {
        if(StringUtils.isEmpty(firstName)&&StringUtils.isEmpty(lastName)&&StringUtils.isEmpty(userName)&&StringUtils.isEmpty(email)){
            return (List<User>) userRepository.findAll();
        }
        return userRepository.search(firstName,lastName, userName, email);
    }
}
