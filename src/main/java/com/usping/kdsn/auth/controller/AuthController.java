package com.usping.kdsn.auth.controller;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import com.usping.kdsn.auth.model.User;
import com.usping.kdsn.util.config.CONFIG;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

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
        String jwtToken = Jwts.builder().setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,CONFIG.getTokenPass()).compact();

        System.out.println(jwtToken);
        return jwtToken;
    }

    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User loginUser) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // check


        String jwtToken;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(CONFIG.getTokenPass());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        jwtToken = Jwts.builder()
                .setSubject(loginUser.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setIssuer("cc")
                .signWith(signatureAlgorithm,signingKey)
                .compact();

        System.out.println(jwtToken);
        System.out.println("Token initiated");
        return jwtToken;
    }
}
