package com.example.board_springboot.service;

import com.example.board_springboot.entity.LoginLog;
import com.example.board_springboot.entity.User;

import com.example.board_springboot.repository.LoginLogRepository;
import com.example.board_springboot.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

//    UsersMapper usersMapper;
    private final UserRepository userRepository;
    private final LoginLogRepository loginLogRepository;

    @Override
    public boolean signUp(User user) {
        boolean result = false;
        boolean isExistUser= userRepository.findByUserId(user.getUserId()) != null;

        if (!isExistUser){
            userRepository.save(user);
            result = true;
        }
        return result;
    }


    @Override
    public boolean login(String userId, String password, String ipAddress, String browser) {
        boolean login = false;
        User user = userRepository.findByUserId(userId);
        if (user != null && user.getPassword().equals(password)) {
            LoginLog loginLog = new LoginLog();
            loginLog.setUserNo(user);
            loginLog.setIpAddress(ipAddress);
            loginLog.setBrowser(parseBrowser(browser));
            loginLog.setCreatedAt(Instant.now());
            loginLogRepository.save(loginLog);
            
            login = true;
        }
        return login;
    }

    private String parseBrowser(String userAgent) {
        if (userAgent == null) return "Unknown";
        if (userAgent.contains("Chrome")) return "Chrome";
        if (userAgent.contains("Firefox")) return "Firefox";
        if (userAgent.contains("Safari") && !userAgent.contains("Chrome")) return "Safari";
        if (userAgent.contains("Edge")) return "Edge";
        if (userAgent.contains("Opera")) return "Opera";
        return "Other";
    }
}
