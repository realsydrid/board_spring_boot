package com.example.board_springboot.repository;

import com.example.board_springboot.entity.Board;
import com.example.board_springboot.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(int id);



    User findByUserId(String userId);


    Object findBoardById(Integer id);
}
