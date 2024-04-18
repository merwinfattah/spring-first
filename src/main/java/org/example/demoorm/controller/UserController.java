package org.example.demoorm.controller;

import org.example.demoorm.exception.UserNotFoundException;
import org.example.demoorm.model.User;
import org.example.demoorm.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserJpaRepository repository;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @RequestMapping("/users")
    public User addUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserData(@PathVariable Long id, @RequestBody User userData) throws Exception {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User dengan id: " + id + "tidak dapat ditemukan"));

        if (!userData.getUserName().isEmpty()) {
            user.setUserName(userData.getUserName());
        }

        if (!userData.getUserPhoneNumber().isEmpty()) {
            user.setUserPhoneNumber(userData.getUserPhoneNumber());
        }

        if (!userData.getUserAddress().isEmpty()) {
            user.setUserAddress(userData.getUserAddress());
        }

        if (!userData.getUserBio().isEmpty()) {
            user.setUserBio(userData.getUserBio());
        }


        User updatedUserData = repository.save(user);
        return ResponseEntity.ok(updatedUserData);
    }
}
