package com.usping.kdsn.auth.controller;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.bean.UserWithBLOBs;
import com.usping.kdsn.service.AuthService;
import com.usping.kdsn.util.config.ConstantConfig;
import com.usping.kdsn.util.model.ResponseMessage;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by @author stan on 17-7-2.
 */
@Controller
@RequestMapping("/auth/")
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 登录
     * @param loginUser 传入信息
     * @return resultMap， 包括成功状态，如果成功，还应该提供token给用户
     */
    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity<ResponseMessage> login(@RequestBody User loginUser) {
        ResponseMessage responseMessage = authService.verifyPassword(loginUser);


       return new ResponseEntity<>(responseMessage, responseMessage.getCode());
    }


    /**
     * 无论成功与否， 都应该返回一个map， 来告知操作成功状态
     * @param user 获取用户注册信息
     * @return resultMap， 包括成功状态，如果成功，还应该提供token给用户
     */
    @CrossOrigin
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<ResponseMessage> signup(@RequestBody User registerUser) {
        ResponseMessage responseMessage = authService.register(registerUser);

        return new ResponseEntity<>(responseMessage, responseMessage.getCode());
    }
//    public ResponseEntity<Map<String, Object>> register(@RequestBody UserWithBLOBs user) {
//        logger.info("load the information of user is" + user.toString());
//        WeakHashMap<String, Object> resultMap = new WeakHashMap<>(3);
//    /*
//      1. make sure that no repeat userName
//      2. Then insert
//     */
//        try {
//            if (null != userService.findByUsername(user.getUserAccount())){
//                return new ResponseEntity<>(HttpStatus.CONFLICT);
//            }
//            userService.saveInstance(user);
//            resultMap.put("token", this.generateToken(user.getUserAccount()));
//            resultMap.put("authorizedUser",user);
//            return new ResponseEntity<>(resultMap,HttpStatus.ACCEPTED);
//
//        }catch (Exception e){
//            logger.info(e.toString());
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }

}
