package com.ash.hms.config;

import com.ash.hms.entities.UserEntity;
import com.ash.hms.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.formLogin(Customizer.withDefaults())

//                .csrf(csrf -> csrf.disable())
//                .formLogin(form -> form.disable())
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)  // these two configs are required to disable spring for security form
                .authorizeHttpRequests(auth -> auth.
                        requestMatchers("/doctor/list" , "/auth/**").permitAll()
//                        .requestMatchers("/doctor/**").hasRole() //specify any role
                        .requestMatchers("/doctor/**").hasAllRoles("ADMIN")
                        .anyRequest().authenticated())

                .build();
    }

//    @Bean
//    UserDetailsService myInmemoryUserDetailsService () {
//        UserDetails normalUser = User.withUsername("Ash1234") // note this user is created in SpringSecurity and is not in our db.
//                .password(passwordEncoder().encode("abcde"))
//                .roles("USER")
//                .build();
//
//        UserDetails adminUser = User.withUsername("Mad1234") // note this user is created in SpringSecurity and is not in our db.
//                .password(passwordEncoder().encode("abcde"))
//                .roles("ADMIN")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(normalUser , adminUser);
//    }



    @Bean
    AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception{
            return config.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
