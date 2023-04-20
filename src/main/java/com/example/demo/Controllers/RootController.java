package com.example.demo.Controllers;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Repositories.UserRepository;

@RestController
public class RootController {

    @Autowired
    private UserRepository userRepository;

    public RootController() {

    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.status(200).header("Content-Type", "text/html").body(
            "<div style='font-weight:bold; color: tomato;'>" 
            + "Hello From TechThursday"
            + "</div>"
            );
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/env")
    public Object env() {
        Map<String, String> env = System.getenv();
        // for (Map.Entry<String, String> entry : env.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }
        return env;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
