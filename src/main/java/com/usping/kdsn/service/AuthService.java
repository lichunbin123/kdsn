package com.usping.kdsn.service;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.util.model.ResponseMessage;

public interface AuthService<T> extends BaseService<T>{
    ResponseMessage verifyPassword(User loginUser);

    ResponseMessage register(User registerUser);
}
