package com.example.board_springboot.controller;


import com.example.board_springboot.mapper.BoardsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    private BoardsMapper boardsMapper;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("boardsList",boardsMapper.findAllBoards());

        return "index";
    }

}
