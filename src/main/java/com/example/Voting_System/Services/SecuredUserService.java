package com.example.Voting_System.Services;

import com.example.Voting_System.Config.Utils;
import com.example.Voting_System.Models.SecuredUser;
import com.example.Voting_System.Repository.SecuredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecuredUserService implements UserDetailsService {
    @Autowired
    SecuredUserRepository securedUserRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return securedUserRepository.findByUsername(username);
    }

    public SecuredUser save(SecuredUser securedUser, String userType){

        String encryptedPwd = encoder.encode(securedUser.getPassword());
        String authorities = Utils.getAuthoritiesForUser().get(userType);

        securedUser.setAuthorities(authorities);
        securedUser.setPassword(encryptedPwd);
        return this.securedUserRepository.save(securedUser);
    }
}
