package com.example.board_springboot.model;

import java.io.Serializable;
import lombok.Data;

/**
 * users
 */
@Data
public class Users implements Serializable {
    private Integer userNo;

    private String userId;

    private String userName;

    private String password;

    private String phoneNo;

    private static final long serialVersionUID = 1L;
}