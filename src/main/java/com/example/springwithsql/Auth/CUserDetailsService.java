package com.example.springwithsql.Auth;

import com.example.springwithsql.Auth.CUserDetails;
import com.example.springwithsql.Database.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CUserDetailsService implements UserDetailsService {
    @Autowired
    private final AccountRepository accountRepository;
    public CUserDetailsService(AccountRepository accountRepository)  {
        this.accountRepository = accountRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository
                .findByUsername(username)
                .map(CUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
