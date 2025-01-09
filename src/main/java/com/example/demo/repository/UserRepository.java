package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // 根据名字查询用户
    Optional<User> findByName(String name);
    
    // 根据邮箱查询用户
    Optional<User> findByEmail(String email);
    
    // 根据名字模糊查询
    List<User> findByNameContaining(String name);
    
    // 根据邮箱模糊查询
    List<User> findByEmailContaining(String email);
    
    // 自定义 JPQL 查询
    @Query("SELECT u FROM User u WHERE u.name LIKE %:keyword% OR u.email LIKE %:keyword%")
    List<User> searchUsers(@Param("keyword") String keyword);
    
    // 自定义原生 SQL 查询
    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    User findUserByNameNative(@Param("name") String name);
    
    // 检查邮箱是否存在
    boolean existsByEmail(String email);
    
    // 根据名字和邮箱查询
    Optional<User> findByNameAndEmail(String name, String email);
} 