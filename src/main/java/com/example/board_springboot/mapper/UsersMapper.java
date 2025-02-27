package com.example.board_springboot.mapper;

import com.example.board_springboot.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UsersMapper {

    int insert(Users record);
    Users findByUserId(String userId);
//    int deleteByPrimaryKey(Integer userNo);

//    int insertSelective(Users record);
//
//    Users selectByPrimaryKey(Integer userNo);
//
//    int updateByPrimaryKeySelective(Users record);
//
//    int updateByPrimaryKey(Users record);
}