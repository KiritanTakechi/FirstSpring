package com.ouka.service;

import com.ouka.model.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserService userService;

    @Override
    public boolean login(String username, String password) {
        return Optional.ofNullable(userService.getUserByUsername(username))
                .map(User::getPassword)
                .orElse("")
                .equals(password);
    }

    @Override
    public boolean isLogin(User user) {
        return userService.getUserByUsername(user.getUsername()) != null;
    }
}
