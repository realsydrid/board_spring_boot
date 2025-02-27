package com.example.board_springboot.controller;

import com.example.board_springboot.model.Users;
import com.example.board_springboot.service.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {


    private UserServiceImp userServiceImp;

    @GetMapping("signUp.do")
    public String signUp(Model model) {

        return "user/signUp";
    }

    @PostMapping("signUp.do")
    public String signUp(Model model,
                         @RequestParam String userId,
                         @RequestParam String userName,
                         @RequestParam String phoneNo,
                         @RequestParam String password
                         ) {
        Users user = new Users();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPhoneNo(phoneNo);
        user.setPassword(password);
        userServiceImp.signUp(user);

        return "user/signUp";
    }

    @GetMapping("login.do")
    public String login(Model model) {
        return "user/login";
    }

    @PostMapping("login.do")
    public String login(Model model, String userId, String password) {
        boolean login = userServiceImp.login(userId, password);
        if (login) {
            System.out.println("로그인성공");
            return "index";
        }
        return "user/login";
    }
}
