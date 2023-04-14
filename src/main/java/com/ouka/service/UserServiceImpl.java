package com.ouka.service;

import com.ouka.mapper.UserMapper;
import com.ouka.model.User;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
@Data
@Accessors(chain = true)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserAll() {
        return userMapper.getUserAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public Integer deleteUserByUsername(String username) {
        return userMapper.deleteUserByUsername(username);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

}
