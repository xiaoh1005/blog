package com.xh.mysite.security.uam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.mysite.domain.UserResource;
import com.xh.mysite.domain.Userinfo;
import com.xh.mysite.reposiroty.ResourceDAO;
import com.xh.mysite.reposiroty.UserDAO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2020/5/18 21:36
 * description
 */
@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserDAO userDAO;

    @Resource
    private ResourceDAO resourceDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userinfo userinfo = userDAO.selectOne(new QueryWrapper<Userinfo>().eq("username", username));
        List<GrantedAuthority> authorities = this.getAuthorities(username);
        if (authorities.size() == 0){
            authorities.add(new SimpleGrantedAuthority("APP_ROLE"));// default add user role as authority.
        }
        return new User(userinfo.getName(),userinfo.getPassword(),authorities);
    }


    /**
     * get authorities from db.
     *
     * @param username name
     * @return list of authorities.
     */
    private List<GrantedAuthority> getAuthorities(String username) {

        //todo. how to get ? role group function.
        List<UserResource> resourceList = resourceDAO.selectList(new QueryWrapper<UserResource>().eq("username", username));
        List<GrantedAuthority> authorities = new ArrayList<>();
        resourceList.forEach(x -> authorities.add(new SimpleUrlResourceAuthority(x.getUri())));//todo. each UserResource get one uri?
        return authorities;
    }




}
