package com.usping.kdsn;

import com.usping.kdsn.util.tools.TokenTool;
import org.junit.Test;

public class TokenToolTest {

    @Test
    public void fTestToken() {
        String tempToken = TokenTool.generateToken("comoestas");
        System.out.println(tempToken);
        System.out.println(TokenTool.parseToken(tempToken));
    }


}
