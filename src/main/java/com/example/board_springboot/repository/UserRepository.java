package com.example.board_springboot.repository;

import com.example.board_springboot.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    User findByUserId(String userId);

}
