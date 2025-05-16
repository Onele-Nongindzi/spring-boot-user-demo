package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestParam String name, @RequestParam String surname) {
        userService.addUser(name, surname);
        return ResponseEntity.ok("User added: " + name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable long id) {
        userService.getUser(id);
        return ResponseEntity.ok("User retrieved");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable long id) {
        userService.removeUser(id);
        return ResponseEntity.ok("User removed");
    }
}