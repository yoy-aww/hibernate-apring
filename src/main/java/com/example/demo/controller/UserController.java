package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 搜索用户
    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String keyword) {
        return userRepository.searchUsers(keyword);
    }

    // 根据邮箱查找用户
    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 检查邮箱是否存在
    @GetMapping("/check-email")
    public boolean checkEmail(@RequestParam String email) {
        return userRepository.existsByEmail(email);
    }
} 