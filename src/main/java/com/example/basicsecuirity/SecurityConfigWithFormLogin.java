package com.example.basicsecuirity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigWithFormLogin {
    @Autowired
    private UserDetailsService myUserDetailsService;


    //take userdetails from database
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http.authorizeHttpRequests(a -> a.anyRequest().authenticated())
              .formLogin(Customizer.withDefaults()).build();
    }


    //Multiple user used manually
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("Role").build();
//
//        UserDetails user2 =
//                User.withDefaultPasswordEncoder()
//                        .username("Indrani")
//                        .password("indu@1234")
//                        .roles("Role").build();
//
//        return new InMemoryUserDetailsManager(user,user2);
//        }

}
