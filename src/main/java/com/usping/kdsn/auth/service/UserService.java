package com.usping.kdsn.auth.service;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.bean.UserWithBLOBs;
import com.usping.kdsn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
            return userMapper.selectAll();
        }

    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findByUsername(String username) {
            return userMapper.selectByUserName(username);
    }

//  public boolean saveUser(User user){
//    return userMapper.saveUser(user);
//  }

    //public boolean updateUser(User user){
    //  return userMapper.updateUser(user);
    //}

    public boolean deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id) == 1;
    }

    public int saveInstance(UserWithBLOBs instance) {
        return userMapper.insertSelective(instance);
    }
}
