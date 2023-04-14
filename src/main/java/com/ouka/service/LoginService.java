package com.ouka.service;

import com.ouka.model.User;

public interface LoginService {
    boolean login(String username, String password);
    boolean isLogin(User user);
}