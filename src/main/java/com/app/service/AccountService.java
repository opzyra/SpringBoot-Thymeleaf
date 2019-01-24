package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.mapper.AccountMapper;
import com.app.security.Account;

@Service
@Transactional
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = accountMapper.selectByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        }
        
        return user;
    }
}
