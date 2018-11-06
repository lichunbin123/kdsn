package com.usping.kdsn.auth;

import com.usping.kdsn.util.tools.MD5Handler;
import org.junit.Test;

public class MD5Test {
    @Test
    public void EncryptTest(){
        String s = "hello,world";
        System.out.println(MD5Handler.Encrypt(s));
        assert MD5Handler.Encrypt(s).equals("3cb95cfbe1035bce8c448fcaf80fe7d9");
    }
}
