package com.example.board_springboot.controller;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {



    @GetMapping("/")
    public String home(Model model) {


        return "index";
    }

}
