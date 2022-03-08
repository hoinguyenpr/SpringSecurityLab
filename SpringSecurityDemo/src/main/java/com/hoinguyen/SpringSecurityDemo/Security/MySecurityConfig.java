package com.hoinguyen.SpringSecurityDemo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyAuthenticationProvider authenticationProvider;


//    //Custom Authentication Manager
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //UserDetail store in memory
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails userDetails = User.withUsername("hoi").password(passwordEncoder.encode("nguyen"))
//                        .authorities("read").build();
//        userDetailsService.createUser(userDetails);
//
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    //Take HTTP security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin();
        http.httpBasic();
        http.authorizeHttpRequests().antMatchers("/hello").authenticated();
        http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);

//        http.httpBasic();
//
//        //All request that coming to application should be authenticated
//        http.authorizeHttpRequests().anyRequest().authenticated();

//        //All request that coming to application should be not authenticated
//        http.authorizeHttpRequests().anyRequest().permitAll();
    }

    //Define a bean return a BCryptPasswordEncoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
