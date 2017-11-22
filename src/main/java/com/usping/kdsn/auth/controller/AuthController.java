package com.usping.kdsn.auth.controller;

import com.usping.kdsn.auth.service.UserService;
import com.usping.kdsn.bean.User;
import com.usping.kdsn.util.config.CONFIG;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by stan on 17-7-2.
 */
//@Controller
//@RequestMapping("/auth/")
public class AuthController {

    private final UserService userService = null;

//    @Autowired
//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }

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

                    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(CONFIG.getTokenPass());
                    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

                    jwtToken = Jwts.builder()
                            .setSubject(loginUser.getUsername())
                            .setIssuedAt(new Date(System.currentTimeMillis()))
                            .signWith(signatureAlgorithm, signingKey)
                            .compact();

                    HashMap<String,Object> resultMap = new HashMap<>();

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
}
