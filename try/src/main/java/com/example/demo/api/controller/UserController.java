package com.example.demo.api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.api.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable int id){
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()){
            return user;
        }
        return null;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){

        userService.addUser(user);
        return user;
    }

    @PatchMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id){

        User userUpdated = userService.updateUser(user, id);
        return userUpdated;
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}   
