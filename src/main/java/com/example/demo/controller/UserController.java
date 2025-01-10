package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @ApiOperation("获取所有用户")
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @ApiOperation("创建新用户")
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        log.info("创建用户请求: {}", userDTO);
        User user = convertToUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    private User convertToUser(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    @ApiOperation("搜索用户")
    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String keyword) {
        return userRepository.searchUsers(keyword);
    }

    @ApiOperation("根据邮箱查找用户")
    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation("检查邮箱是否存在")
    @GetMapping("/check-email")
    public boolean checkEmail(@RequestParam String email) {
        return userRepository.existsByEmail(email);
    }
} 