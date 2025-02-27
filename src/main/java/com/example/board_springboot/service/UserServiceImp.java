package com.example.board_springboot.service;

import com.example.board_springboot.mapper.UsersMapper;
import com.example.board_springboot.model.Users;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    UsersMapper usersMapper;

    @Override
    public boolean signUp(Users user) {

        return usersMapper.insert(user)>0;
    }

    @Override
    public boolean login(String userId, String password) {
        boolean login = false;
        Users users = usersMapper.findByUserId(userId);
        if (users != null && users.getPassword().equals(password) ) {
            login = true;
        }
        return login;
    }
}
