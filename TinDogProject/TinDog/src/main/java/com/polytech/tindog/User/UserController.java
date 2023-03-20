package com.polytech.tindog.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String Welcome(){
        return "Hello Visitor";
    }

    @GetMapping("/home")
    public String Home(){
        return "This is the home page";
    }

    @GetMapping("/private")
    public String Prive(){
        return "This page should be private";
    }

    // Create owner with the UUID sent by the createUser API
    @PostMapping("/create-user")
    public UUID createUser(@RequestParam("email") String email, @RequestParam("password") String password) throws Exception {
        return userService.createUser(email,password);
    }

    @PostMapping("/login")
    public UUID loginUser (@RequestParam("email") String email, @RequestParam("password") String password) throws Exception {
       return userService.login(email,password);
    }

    @GetMapping("/userId")
    public User getUserById(@RequestParam("id") UUID id) throws Exception {
        return userService.getUserById(id);
    }

    @GetMapping("/userEmail")
    public User getUserByEmail(@RequestParam("email") String email) throws Exception {
        return userService.getUserByEmail(email);
    }
}
