package com.manong.config.security;

import com.manong.config.security.handler.AnonymousAuthenticationHandler;
import com.manong.config.security.handler.CustomerAccessDeniedHandler;
import com.manong.config.security.handler.LoginFailureHandler;
import com.manong.config.security.handler.LoginSuccessHandler;
import com.manong.config.security.service.CustomerUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * Spring Security 配置类型
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginSuccessHandler loginSuccessHandler;
    @Resource
    private LoginFailureHandler loginFailureHandler;
    @Resource
    private AnonymousAuthenticationHandler anonymousAuthenticationHandler;
    @Resource
    private CustomerAccessDeniedHandler customerAccessDeniedHandler;
    @Resource
    private CustomerUserDetailsService customerUserDetailsService;

    /**
     * 注入加密类
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 处理登录认证
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登录过程处理
        http.formLogin()//表单登录
                .loginProcessingUrl("/api/user/login")//登录请求url地址，自定义即可
                .successHandler(loginSuccessHandler)//表单登录成功处理器
                .failureHandler(loginFailureHandler)//表单登录失败处理器
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//不创建Session
                .and()
                .authorizeRequests()//设置需要拦截的请求
                .antMatchers("/api/user/login").permitAll()//登录请求放行（不拦截）
                .anyRequest().authenticated()//其他请求都需要进行身份认证
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(anonymousAuthenticationHandler)//匿名无权限访问
                .accessDeniedHandler(customerAccessDeniedHandler)//认证用户无权限范围跟
                .and()
                .cors();//支持跨域请求
    }

    /**
     * 配置认证处理器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailsService).passwordEncoder(passwordEncoder());
    }

}
