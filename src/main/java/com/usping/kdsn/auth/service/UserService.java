package com.usping.kdsn.auth.service;

import com.usping.kdsn.auth.mapper.UserMapper;
import com.usping.kdsn.auth.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by stan on 17-7-2.
 */
@Component
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List findAll() {
        return userMapper.findAll();
    }

    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

//  public boolean saveUser(User user){
//    return userMapper.saveUser(user);
//  }

    //public boolean updateUser(User user){
    //  return userMapper.updateUser(user);
    //}

    public boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

}
