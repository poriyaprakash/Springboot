package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        boolean exist = userService.saveNewUser(user);
        if(!exist){
            return new ResponseEntity<>("User Exists!!",HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
}
