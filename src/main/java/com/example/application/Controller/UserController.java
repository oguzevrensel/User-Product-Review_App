package com.example.application.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.application.Entity.User;
import com.example.application.Service.UserService;

import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public List<User> add(@RequestBody User user){
        return this.userService.add(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return this.userService.findAll();
    }
}