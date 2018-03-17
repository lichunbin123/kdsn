package com.usping.kdsn.auth.controller;

import com.usping.kdsn.auth.service.UserService;
import com.usping.kdsn.bean.User;
import com.usping.kdsn.bean.UserWithBLOBs;
import com.usping.kdsn.util.config.ConstantConfig;
import com.usping.kdsn.util.model.ResultMap;
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

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    private String generateToken(String username) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ConstantConfig.getTokenPass());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        String jwtToken;

        jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(signatureAlgorithm, signingKey)
                .compact();
        return jwtToken;
    }

    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> login(@RequestBody User loginUser) {


        if (null == loginUser.getUsername() || null == loginUser.getPassword()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            try {
                User user = userService.findByUsername(loginUser.getUsername());
                if (!loginUser.getPassword().equals(user.getPassword())) {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                } else {

                    HashMap<String,Object> resultMap = new HashMap<>(2);

                    resultMap.put("token",generateToken(loginUser.getUsername()));
                    resultMap.put("authorizedUser",user);

                    return new ResponseEntity<>(resultMap, HttpStatus.OK);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
    }

    /**
     * 无论成功与否， 都应该返回一个map， 来告知操作成功状态
     * @param user 获取用户注册信息
     * @return resultMap， 包括成功状态，如果成功，还应该提供token给用户
     */
    @CrossOrigin
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> register(@RequestBody UserWithBLOBs user) {
        logger.info("load the information of user is" + user.toString());
        WeakHashMap<String, Object> resultMap = new WeakHashMap<>(3);
    /*
      1. make sure that no repeat userName
      2. Then insert
     */
        try {
            if (null != userService.findByUsername(user.getUsername())){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            userService.saveInstance(user);
            resultMap.put("token", this.generateToken(user.getUsername()));
            resultMap.put("authorizedUser",user);
            return new ResponseEntity<>(resultMap,HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
