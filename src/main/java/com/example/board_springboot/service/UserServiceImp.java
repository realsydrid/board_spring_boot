package com.example.board_springboot.service;

import com.example.board_springboot.entity.User;

import com.example.board_springboot.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

//    UsersMapper usersMapper;
    UserRepository userRepository;

    @Override
    public boolean signUp(User user) {
        boolean result = false;

        if (!isExistUserId(user.getUserId())){
            userRepository.save(user);
            result = true;
        }
        return result;
    }

    @Override
    public boolean isExistUserId(String userId) {
        return userRepository.findByUserId(userId) != null;
    }

    @Override
    public boolean login(String userId, String password) {
        boolean login = false;
        User user = userRepository.findByUserId(userId);
        if (user!=null) {
            if (user.getPassword().equals(password)) {
                login = true;
            }
        }

        return login;
    }
}
