package com.ouka.service;

import com.ouka.model.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private User user;
    @Resource
    private UserService userService;

    @Override
    public boolean register(String nickname,
                            String username,
                            String password) {
        var line = userService.insertUser(user.setNickname(nickname).setUsername(username).setPassword(password));
        return line > 0;
    }

    @Override
    public boolean isRegistered(String username) {
        return userService.getUserByUsername(username) != null;
    }
}
