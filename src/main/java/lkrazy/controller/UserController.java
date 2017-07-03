package lkrazy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lkrazy.pojo.User;
import lkrazy.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

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
        userRepository.save(user);
    }
}
