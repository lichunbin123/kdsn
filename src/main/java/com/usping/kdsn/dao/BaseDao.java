package com.usping.kdsn.dao;

import com.usping.kdsn.bean.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface BaseDao<T> {
    int delete() throws DataAccessException;
    int update(T t) throws DataAccessException;
    T select() throws DataAccessException;
    int insert(T t) throws DataAccessException;

    List<User> selectByAccount(String username) throws DataAccessException;

    List<User> selectByEmail(String email) throws DataAccessException;

    List<User> selectByNickname(String nickname) throws DataAccessException;
}
