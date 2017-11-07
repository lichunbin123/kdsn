package com.usping.kdsn.auth.controller;

import java.util.Date;
import java.util.HashMap;

import com.usping.kdsn.auth.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stan on 17-7-2.
 */
@Controller
@RequestMapping("/auth/")
public class AuthController {

    @RequestMapping("/test")
    public
    @ResponseBody
    HashMap<String, Boolean>
    test() {
        HashMap<String, Boolean> returnMap = new HashMap<String, Boolean>();

        returnMap.put("success", true);

        return returnMap;
    }

    @RequestMapping("/testFilter")
    @ResponseBody
    public String testFilter(){
        String jwtToken = Jwts.builder().setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"woshinidebaba").compact();

        System.out.println(jwtToken);
        return jwtToken;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User loginUser) {
//        User loginUser = new User();
        loginUser.setUsername("sb");
        String jwtToken;

        jwtToken = Jwts.builder().setSubject(loginUser.getUsername()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"woshinidebaba").compact();
        System.out.println(jwtToken);
        return jwtToken;
    }


}
