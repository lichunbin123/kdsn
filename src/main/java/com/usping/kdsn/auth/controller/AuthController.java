package com.usping.kdsn.auth.controller;

import com.usping.kdsn.auth.service.UserService;
import com.usping.kdsn.bean.User;
import com.usping.kdsn.bean.UserWithBLOBs;
import com.usping.kdsn.util.config.ConstantConfig;
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

    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> login(@RequestBody User loginUser) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        if (null == loginUser.getUsername() || null == loginUser.getPassword()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            try {
                User user = userService.findByUsername(loginUser.getUsername());
                if (!loginUser.getPassword().equals(user.getPassword())) {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                } else {
                    String jwtToken;

                    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ConstantConfig.getTokenPass());
                    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

                    jwtToken = Jwts.builder()
                            .setSubject(loginUser.getUsername())
                            .setIssuedAt(new Date(System.currentTimeMillis()))
                            .signWith(signatureAlgorithm, signingKey)
                            .compact();

                    HashMap<String,Object> resultMap = new HashMap<>(2);

                    resultMap.put("token",jwtToken);
                    resultMap.put("authorizedUser",user);

                    return new ResponseEntity<>(resultMap, HttpStatus.OK);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
    }

    @CrossOrigin
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody UserWithBLOBs user) {
        logger.info("load the information of user is" + user.toString());
    /*
      1. make sure that no repeat userName
      2. Then insert
     */
        try {
            if (null != userService.findByUsername(user.getUsername())){
                return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            }
            userService.saveInstance(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
