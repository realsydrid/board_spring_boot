package com.example.board_springboot.controller;


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
//    private BoardsMapper boardsMapper;
//
    private BoardsService boardsService;


    @GetMapping("boardHome.do")
    public String boardHome(Model model) {
        model.addAttribute("boardsList",boardsService.readAll());
        return "board/boardHome";
    }

}
