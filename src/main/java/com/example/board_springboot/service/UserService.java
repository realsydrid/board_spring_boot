package com.example.board_springboot.service;

import com.example.board_springboot.entity.User;

public interface UserService {
    boolean signUp(User user);
    boolean login(String userId, String password, String ipAddress, String browser);


}
