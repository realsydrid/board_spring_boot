package com.example.board_springboot.controller;


import com.example.board_springboot.entity.User;
import com.example.board_springboot.repository.BoardRepository;
import com.example.board_springboot.repository.UserRepository;
import com.example.board_springboot.service.BoardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardsController {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    //    private BoardsMapper boardsMapper;
//
    private BoardsService boardsService;


    @GetMapping("boardHome.do")
    public String boardHome(Model model) {
        model.addAttribute("boardsList",boardsService.readAll());

        return "board/boardHome";
    }
    @GetMapping("searchByUserNo.do")
    public String searchByUserNo(Model model) {
        User user=userRepository.findByUserId("test1");
        System.out.println(user);
        model.addAttribute("boardsList",boardsService.getBoardsByUserNo(1));
        //유저번호로검색구현
        return "board/searchByUserNo";

    }

}
