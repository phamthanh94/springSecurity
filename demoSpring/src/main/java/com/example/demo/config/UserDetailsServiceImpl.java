package com.example.demo.config;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(userName);
        if (user == null){
            throw new UsernameNotFoundException("Not found :" + userName);
        }
        List<String> listRole = Arrays.asList(user.getRoleName().split(","));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (listRole != null && !listRole.isEmpty()){
            for (String role : listRole){
                GrantedAuthority  authority = new SimpleGrantedAuthority(role);
                grantedAuthorities.add(authority);
            }
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
