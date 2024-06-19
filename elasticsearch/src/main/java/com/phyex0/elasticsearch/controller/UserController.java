package com.phyex0.elasticsearch.controller;

import com.phyex0.elasticsearch.model.User;
import com.phyex0.elasticsearch.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(UUID id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<User>> getUsersByFilter(@RequestParam LocalDate localDate) {
        return ResponseEntity.ok(userService.getUserByFilter(localDate));
    }
}