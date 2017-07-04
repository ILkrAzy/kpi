package org.kpi.controller;

import org.kpi.pojo.User;
import org.kpi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @RequestMapping
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).get(0);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
