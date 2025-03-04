package com.example.board_springboot.service;

import com.example.board_springboot.entity.Board;
import com.example.board_springboot.entity.User;


import java.util.List;


public interface BoardsService {
    List<Board> readAll();
    List<Board> getBoardsByUserNo(int userNo);
    boolean writeBoard(Board board);




}
