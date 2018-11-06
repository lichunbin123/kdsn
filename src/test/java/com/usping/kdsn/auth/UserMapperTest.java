package com.usping.kdsn.auth;

import com.usping.kdsn.KdsnApplication;
import com.usping.kdsn.bean.User;
import com.usping.kdsn.mapper.UserMapper;
import com.usping.kdsn.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = KdsnApplication.class)
@RunWith(SpringRunner.class)
public class UserMapperTest{

    @Autowired
    private  UserMapper userMapper = null;

    @Autowired
    private AuthService authService;

    public UserMapperTest(){

    }

    @Test
    @Transactional
    @Rollback
    public void testRegister() {
        System.out.println();
        System.out.println(authService.register(User.builder().userPassword("333").userAccount("rh155551").userEmail("jfdaojff").userNickname("dddaas").build()));
    }
}