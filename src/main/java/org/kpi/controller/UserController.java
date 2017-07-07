package org.kpi.controller;

import java.util.List;

import javax.validation.Valid;

import org.kpi.model.User;
import org.kpi.model.dto.NewUser;
import org.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/{username}")
    public User getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @PostMapping
    public void create(@Valid NewUser user) {
        userService.save(user.toModel(passwordEncoder));
    }
}
