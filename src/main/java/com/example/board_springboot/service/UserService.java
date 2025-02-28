package com.example.board_springboot.service;

import com.example.board_springboot.dto.UserSessionDto;
import com.example.board_springboot.entity.User;

public interface UserService {
    boolean signUp(User user);
    UserSessionDto login(String userId, String password, String ipAddress, String browser);


}
