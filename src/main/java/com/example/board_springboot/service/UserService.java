package com.example.board_springboot.service;

import com.example.board_springboot.model.Users;

public interface UserService {
    public boolean signUp(Users user);
    public boolean login(String userId, String password);
}
