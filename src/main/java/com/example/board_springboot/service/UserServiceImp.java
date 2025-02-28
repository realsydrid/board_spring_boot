package com.example.board_springboot.service;

import com.example.board_springboot.dto.UserSessionDto;
import com.example.board_springboot.entity.LoginLog;
import com.example.board_springboot.entity.PasswordChangeLog;
import com.example.board_springboot.entity.User;

import com.example.board_springboot.repository.LoginLogRepository;
import com.example.board_springboot.repository.PasswordChangeLogRepository;
import com.example.board_springboot.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final LoginLogRepository loginLogRepository;
    private final PasswordChangeLogRepository passwordChangeLogRepository;

    @Override
    public boolean signUp(User user) {
        boolean result = false;
        boolean isExistUser= userRepository.findByUserId(user.getUserId()) != null;

        if (!isExistUser){
            userRepository.save(user);
            PasswordChangeLog passwordChangeLog =new PasswordChangeLog();
            passwordChangeLog.setUserId(user.getUserId());
            passwordChangeLog.setChangedPassword(user.getPassword());
            passwordChangeLogRepository.save(passwordChangeLog);
            result = true;
        }
        return result;
    }


    @Override
    public UserSessionDto login(String userId, String password, String ipAddress, String browser) {
        User user = userRepository.findByUserId(userId);
        if (user != null && user.getPassword().equals(password)) {
            LoginLog loginLog = new LoginLog();
            loginLog.setUserNo(user);
            loginLog.setIpAddress(ipAddress);
            loginLog.setBrowser(parseBrowser(browser));
            loginLogRepository.save(loginLog);
            return new UserSessionDto(user);
        }
        return null;
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
