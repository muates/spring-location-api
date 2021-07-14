package com.dev.springlocationapi.controller;

import com.dev.springlocationapi.domain.User;
import com.dev.springlocationapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping({"","/"})
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping({"","/"})
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void updateUserById(@RequestBody User user, @PathVariable Long id){
        userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
