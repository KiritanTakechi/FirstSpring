package com.ouka.service;

import com.ouka.model.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
    @Resource
    private UserService userService;

    @Override
    public boolean isLogin(User user) {
        return userService.getUserByUsername(user.getUsername()) != null;
    }
}
