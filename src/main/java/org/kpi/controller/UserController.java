package org.kpi.controller;

import org.kpi.model.User;
import org.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping
    public User getByUsername(String username) {
        return userService.getByUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
}
