package com.example.board_springboot.repository;

import com.example.board_springboot.entity.Board;
import com.example.board_springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void insertUser() {
        User user = new User();
        user.setUserName("jpatest");
        user.setPassword("1234");
        user.setPhoneNo("123456789");
        user.setUserId("jpatest");
        userRepository.save(user);



    }

    @Test
    @Transactional
    void findById() {

    }
}