package com.example.board_springboot.controller;

import com.example.board_springboot.dto.UserSessionDto;
import com.example.board_springboot.entity.User;
import com.example.board_springboot.repository.UserRepository;
import com.example.board_springboot.service.UserServiceImp;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserRepository userRepository;
    private UserServiceImp userServiceImp;


    @GetMapping("signUp.do")
    public String signUp(Model model) {

        return "user/signUp";
    }

    @PostMapping("signUp.do")
    public String signUp(Model model, User user, RedirectAttributes redirectAttributes) {
        boolean result = userServiceImp.signUp(user);
        if (result) {
            redirectAttributes.addFlashAttribute("signUpSuccess", true);
            return "redirect:/user/login.do";
        }
        model.addAttribute("isExistId", true);
        return "user/signUp";
    }

    @GetMapping("login.do")
    public String login(HttpSession session,
                        HttpServletRequest httpServletRequest,
                        Model model,
                        @RequestParam(required = false) String redirect) {
        if (redirect != null) {
            model.addAttribute("redirect", redirect);
        }
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("rememberedId")) {
                    model.addAttribute("rememberedId", cookie.getValue());
                    break;
                }
            }
        }


        if (session.getAttribute("userSessionDto") != null) {
            return "redirect:/";
        }
        return "user/login";
    }

    @PostMapping("login.do")
    public String login(Model model,
                        String userId,
                        String password,
                        @RequestParam(required = false, defaultValue = "false") boolean remember_id,
                        @RequestParam(required = false) String redirect,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse) {

        String ipAddress = request.getRemoteAddr();
        String browser = request.getHeader("User-Agent");
        UserSessionDto userSessionDto = userServiceImp.login(userId, password, ipAddress, browser);
        if (userSessionDto != null) {

            //아이디기억하기
            if (remember_id) {
                Cookie rememberedIdCookie = new Cookie("rememberedId", userId);
                rememberedIdCookie.setPath("/");
                rememberedIdCookie.setMaxAge(60 * 60 * 24 * 30);
                httpServletResponse.addCookie(rememberedIdCookie);

            } else {
                Cookie rememberedIdCookie = new Cookie("rememberedId", userId);
                rememberedIdCookie.setPath("/");
                rememberedIdCookie.setMaxAge(0);
                httpServletResponse.addCookie(rememberedIdCookie);
            }

            HttpSession session = request.getSession();
            session.setAttribute("userSessionDto", userSessionDto);
            session.setMaxInactiveInterval(60 * 30);
            redirectAttributes.addFlashAttribute("loginSuccess", true);
            if (redirect != null) {
                return "redirect:"+redirect;
            }else {

            return "redirect:/";
            }
        }
        redirectAttributes.addFlashAttribute("loginError", true);
        return "redirect:/user/login.do";
    }

    @GetMapping("myInfo.do")
    public String myinfo(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserSessionDto userSessionDto = (UserSessionDto) session.getAttribute("userSessionDto");
        model.addAttribute("userName", userSessionDto.getUserName());
        return "user/myInfo";
    }

    @GetMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
