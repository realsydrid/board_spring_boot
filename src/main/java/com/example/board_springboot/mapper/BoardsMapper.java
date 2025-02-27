package com.example.board_springboot.mapper;

import com.example.board_springboot.model.Boards;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardsMapper {
    List<Boards> findAllBoards();

}