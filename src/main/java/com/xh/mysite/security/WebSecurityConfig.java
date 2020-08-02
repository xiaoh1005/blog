package com.xh.mysite.security;

import com.xh.mysite.security.jwt.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.csrf.CsrfFilter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2020/5/12 22:48
 * description
 */

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    @Qualifier("myUserDetailsService")
    UserDetailsService userDetailsService;

    /*@Resource
    @Qualifier("CsrfFilter")
    private CSRFFilter cSRFFilter;

    @Resource
    @Qualifier("jwtFilter")
    private JWTFilter jwtFilter;


    @Resource
    @Qualifier("filterSecurityInterceptor")
    private FilterSecurityInterceptor filterSecurityInterceptor;

    @Resource
    @Qualifier("logoutSuccessHandler")
    private HttpStatusReturningLogoutSuccessHandler logoutSuccessHandler;*/




    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setUserDetailsPasswordService(); todo. 06-03 00:10
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        /*
        BAuthenticationProvider.setUserDetailsService(userDetailsService);
        dBAuthenticationProvider.setUserService((UserService)userDetailsService);
        dBAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        dBAuthenticationProvider.setAuthorityService(authorityService);
        dBAuthenticationProvider.setAppConfig(appConfig);
        dBAuthenticationProvider.setItrustConfig(itrustConfig);*/
        return authenticationProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }


    /**
     * UserDetailsService ---------->UserDetails loadUserByUsername(String username) .返回 UserDetails 对象
     * UserDetails： 是个接口，主要包括密码 账号 和 权限集合： Collection<? extends GrantedAuthority> getAuthorities()。
     * UserDetails 实现有 User 类。
     * 构造方法传入
     * User(String username, String password, boolean enabled,
     * boolean accountNonExpired, boolean credentialsNonExpired,
     * boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
     * 所以 最后选择 User 作为 UserDetailsService 返回值（当然可以自己实现 UserDetails ）。
     * <p>
     * <p>
     * GrantedAuthorites  ---->String getAuthority();  s设置成urls string.
     * <p>
     * 实现 AccessDecisionManager 。 分解 string。 判断访问的url 在不在其中  在 则vote 不在则reject。
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //For stateless application, CSRF token is not required as application does not need JSessionID in Cookie
        //Application use JWT token for each request, CSRF attack not possible
        //Warning: Enable CSRF and stateless at same time lead to random 403 error under heavy load
        http
                .authorizeRequests().antMatchers(HttpMethod.TRACE, "**").denyAll()
                .and()
                .csrf().disable()
                //.addFilterBefore(filterSecurityInterceptor, FilterSecurityInterceptor.class)
                //.addFilterBefore(openEntityManagerInViewFilter, SecurityContextPersistenceFilter.class)  //for JPA

                //.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                //.addFilterAfter(cSRFFilter, CsrfFilter.class)
                .headers().frameOptions().sameOrigin()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
//       http.exceptionHandling().authenticationEntryPoint(new BasicAuthenticationEntryPoint());
//       http.logout().logoutSuccessHandler(logoutSuccessHandler);
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        List<AuthenticationProvider> providerList = new ArrayList<>();
        providerList.add(authenticationProvider());
        ProviderManager authenticationManager = new ProviderManager(providerList);
        authenticationManager.setEraseCredentialsAfterAuthentication(true);
        return authenticationManager;
    }
}
