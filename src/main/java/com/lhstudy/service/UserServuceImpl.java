package com.lhstudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: SpringBootSecurity
 * @BelongsPackage: com.lhstudy.service
 * @Author: LHao
 * @CreateTime: 2023-10-17  22:59
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserServuceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 自定义登录
         *      admin
         **/
        if (!("admin".equals(username))){
            System.out.println("用户记录不存在！");
            return null;
        }


        String password = encoder.encode("123456");

        return new User(username,password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
