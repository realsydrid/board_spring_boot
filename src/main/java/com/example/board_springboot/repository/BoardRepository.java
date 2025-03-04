package com.example.board_springboot.repository;

import com.example.board_springboot.entity.Board;
import com.example.board_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
    List<Board> findBoardsByUserId(User user);
    List<Board> findByUser_Id(int userNo);
}
