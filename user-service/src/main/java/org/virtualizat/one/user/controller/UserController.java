package org.virtualizat.one.user.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.virtualizat.one.user.entity.User;
import org.virtualizat.one.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value="createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userCreate = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreate);
    }
    @GetMapping(value="listUser")
    public ResponseEntity<List<User>> listUser(){
        List<User> users = userService.listAllUser();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

}
