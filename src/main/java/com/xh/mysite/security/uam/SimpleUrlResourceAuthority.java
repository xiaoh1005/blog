package com.xh.mysite.security.uam;

import org.springframework.security.core.GrantedAuthority;

/**
 * author  Xiao Hong
 * date  2020/6/2 23:47
 * description
 */

public class SimpleUrlResourceAuthority implements GrantedAuthority {


    private String uri;

    public SimpleUrlResourceAuthority(String uri) {
        this.uri = uri;
    }

    /**
     * use uri as authority
     * @return uri string.
     */
    @Override
    public String getAuthority() {
        return uri;
    }


}
