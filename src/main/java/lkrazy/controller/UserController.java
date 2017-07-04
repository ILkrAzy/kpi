package lkrazy.controller;

import lkrazy.pojo.User;
import lkrazy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        userRepository.save(user);
    }
}
