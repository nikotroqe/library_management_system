package com.lms.controller;

import com.lms.model.Book;
import com.lms.model.User;
import com.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*@PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }*/
    @PostMapping("/createUser")
    public ResponseEntity<String> user(@RequestParam String name, @RequestParam String surname, @RequestParam String username,
                                           @RequestParam String password, @RequestParam String role, @RequestParam ZonedDateTime createdDate) {
        userService.createUser(name,surname,username, password, role,createdDate);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody User user) {
        User updatedUser = userService.updatedUser(userId, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

}
