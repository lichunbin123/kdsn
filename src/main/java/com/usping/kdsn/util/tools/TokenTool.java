package com.usping.kdsn.util.tools;


import com.usping.kdsn.util.config.ConstantConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class TokenTool {
    private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;


    public static String generateToken(String originText) {

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ConstantConfig.getTokenPass());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        String jwtToken;

        jwtToken = Jwts.builder()
                .setSubject(originText)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(signatureAlgorithm, signingKey)
                .compact();
        return jwtToken;
    }

    public static String parseToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(ConstantConfig.getTokenPass()))
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
