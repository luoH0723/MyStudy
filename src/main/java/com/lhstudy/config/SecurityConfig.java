package com.lhstudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @BelongsProject: SpringBootSecurity
 * @BelongsPackage: com.lhstudy.config
 * @Author: LHao
 * @CreateTime: 2023-10-17  23:13
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http)throws Exception {
        //表单提交
        http.formLogin()
                //自定义登录页面
                .loginPage("/login.html")
                //当发现/login是任务额是登录
                .loginProcessingUrl("/login")
                //登录成功后跳转页面.POST请求
                .successForwardUrl("toMain");

        //过滤
        http.authorizeRequests()
                //login.html不需要被认证
                .antMatchers("/login.html").permitAll()
                //所有请求都必须被认证，必须登录后被访问
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();

    }

}
