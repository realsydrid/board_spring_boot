package com.example.board_springboot.service;

import com.example.board_springboot.model.Boards;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardsService {
    List<Boards> readAll();



}
