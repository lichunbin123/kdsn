package com.usping.kdsn.service;

import org.springframework.dao.DataAccessException;

public interface BaseService<T> {
    int delete(T t);

    int update(T t);

    int insert(T t);

    T select(T t);
}