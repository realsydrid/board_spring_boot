package com.example.board_springboot.service;

import com.example.board_springboot.entity.Board;
import com.example.board_springboot.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardsServiceImp  implements BoardsService {


    BoardRepository boardRepository;

    @Override
    public List<Board> readAll() {
        return boardRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Board> getBoardsByUserNo(int userNo) {
        return boardRepository.findByUser_Id(userNo);
    }

    @Override
    public boolean writeBoard(Board board) {
        boolean result = false;
        if (board.getTitle() == null || board.getContent() == null) {
            return false;
        }
        boardRepository.save(board);
        return result;
    }
}
