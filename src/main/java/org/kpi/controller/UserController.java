package org.kpi.controller;

import org.kpi.model.Role;
import org.kpi.model.User;
import org.kpi.model.dto.NewUser;
import org.kpi.service.RoleService;
import org.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    private RoleService roleService;

    @Autowired
    public UserController(UserService userService,
            PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<NewUser> getByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        if (user == null) {
            return new ResponseEntity<NewUser>(HttpStatus.NOT_FOUND);
        }
        NewUser newUser = NewUser.fromModel(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping
    public void create(@Valid @RequestBody NewUser newUser) {
        User user = newUser.toModel(passwordEncoder);
        Role role = roleService.getRoleByName(newUser.getRole());
        user.setRole(role);
        userService.save(user);
    }

    @GetMapping
    public ResponseEntity<List<NewUser>> search(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String query) {
        List<User> users = new ArrayList<>();
        if (!StringUtils.isEmpty(query)) {
            users = userService.searchEverything(query);
        } else {
            users = userService.search(firstName, lastName, userName, email);
        }
        if (users == null || users.isEmpty()) {
            return new ResponseEntity<List<NewUser>>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(NewUser.toList(users));
    }

}
