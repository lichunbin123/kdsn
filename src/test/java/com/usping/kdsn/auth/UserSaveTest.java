package com.usping.kdsn.auth;

import com.usping.kdsn.KdsnApplication;
import com.usping.kdsn.auth.service.UserService;
import com.usping.kdsn.bean.UserWithBLOBs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author ning on 18-3-8.
 * @project kdsn
 */
@RunWith(SpringRunner.class)
//@Transactional
@SpringBootTest(classes = KdsnApplication.class)
public class UserSaveTest {

    @Autowired
    private UserService userService;

    @Test
    public void insert() throws InterruptedException {


    }
}
