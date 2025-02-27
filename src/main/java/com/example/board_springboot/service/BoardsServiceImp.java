package com.example.board_springboot.service;

import com.example.board_springboot.mapper.BoardsMapper;
import com.example.board_springboot.model.Boards;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardsServiceImp  implements BoardsService {

    BoardsMapper boardsMapper;

    @Override
    public List<Boards> readAll() {
        return boardsMapper.findAllBoards();
    }
}
