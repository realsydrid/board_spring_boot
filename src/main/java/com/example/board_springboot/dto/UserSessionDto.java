package com.example.board_springboot.dto;

import com.example.board_springboot.entity.User;
import lombok.Getter;

@Getter
public class UserSessionDto {
    private final Integer userNo;
    private final String userName;


    public UserSessionDto(User user) {
        this.userNo = user.getId();
        this.userName = user.getUserName();

    }
}
