package com.example.Voting_System.Config;

import com.example.Voting_System.Services.SecuredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecuredUserService securedUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securedUserService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.
                httpBasic().and().
                csrf().disable().
                authorizeRequests()
                .antMatchers(HttpMethod.GET, "/voter/**").hasAuthority(Constants.VOTER_INFO_SELF_AUTHORITY)
                .antMatchers(HttpMethod.GET, "/voter-by-id/**").hasAuthority(Constants.VOTER_INFO_AUTHORITY)
                .antMatchers(HttpMethod.POST, "/admin/**").hasAuthority(Constants.CREATE_ADMIN_AUTHORITY)
                .antMatchers(HttpMethod.GET, "/see-votes/**").hasAuthority(Constants.SEE_VOTES_AUTHORITY)
                .antMatchers(HttpMethod.POST, "/vote/**").hasAuthority(Constants.VOTE_AUTHORITY)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();

    }
}