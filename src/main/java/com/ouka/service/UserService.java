package com.ouka.service;

import com.ouka.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserAll();
    User getUserById(Integer id);
    User getUserByUsername(String username);
    Integer insertUser(User user);
    Integer deleteUserById(Integer id);
    Integer deleteUserByUsername(String username);
    Integer updateUser(User user);

}
