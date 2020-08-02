package com.xh.mysite.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * author  Xiao Hong
 * date  2020/6/20 11:09
 * description
 */

@Component
public class TokenProvider {


    public boolean validateToken(String jwt) {

        return  false;
    }

    public Authentication getAuthentication(String jwt) {

        return null;
    }
}
