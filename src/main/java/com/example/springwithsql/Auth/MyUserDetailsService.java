package com.example.springwithsql.Auth;

import com.example.springwithsql.Auth.Models.SecurityUser;
import com.example.springwithsql.Auth.Trash.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private final MyUserRepository myUserRepository;
    public MyUserDetailsService(MyUserRepository myUserRepository)  {
        this.myUserRepository = myUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return myUserRepository
                .findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
