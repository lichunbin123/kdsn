package com.usping.kdsn.service;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.util.model.ResponseMessage;

public interface AuthService<T> extends BaseService<T>{
    /**
     * 登录
     * @param loginUser 传入信息
     * @return resultMap， 包括成功状态，如果成功，还应该提供token给用户
     */
    ResponseMessage verifyPassword(User loginUser);

    ResponseMessage register(User registerUser);
}
