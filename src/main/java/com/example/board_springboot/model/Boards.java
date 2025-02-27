package com.example.board_springboot.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * boards
 */
@Data
public class Boards implements Serializable {
    private int boardId;

    private String title;

    private String content;

    private Date createdAt;

    private Integer userNo;

    private String userName;

    private static final long serialVersionUID = 1L;
}