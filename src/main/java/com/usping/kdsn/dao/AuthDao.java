package com.usping.kdsn.dao;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthDao implements BaseDao<User>{

    private final UserMapper userMapper;

    @Autowired
    public AuthDao(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public int delete() throws DataAccessException {
        return 0;
    }

    @Override
    public int update(String password,String account) throws DataAccessException {
        return userMapper.update(password,account);
    }

    @Override
    public User select() throws DataAccessException {
        return null;
    }

    @Override
    public int insert(User user) throws DataAccessException {
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectByAccount(String account) throws DataAccessException {
        return userMapper.selectByAccount(account);
    }

    @Override
    public List<User> selectByEmail(String email) throws DataAccessException{
        return userMapper.selectByEmail(email);
    }

    @Override
    public List<User> selectByNickname(String nickname) throws DataAccessException{
        return userMapper.selectByNickname(nickname);
    }
}
