package com.usping.kdsn.util.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Handler {

    /**
     * MD5加密
     * @param str 需要加密的字符串
     * @return 返回需要加密
     */
    public static String Encrypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encrypt cannot be null or zero length");
        }
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (byte aHash : hash) {
                if ((0xff & aHash) < 0x10) {
                    hexString.append("0").append(Integer.toHexString((0xFF & aHash)));
                } else {
                    hexString.append(Integer.toHexString(0xFF & aHash));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

}
