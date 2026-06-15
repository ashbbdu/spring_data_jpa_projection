package com.ash.hms.services;

import com.ash.hms.dto.LoginDto;
import com.ash.hms.entities.UserEntity;
import com.ash.hms.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
//    to avoid circular exception
//    Description:
//
//    The dependencies of some of the beans in the application context form a cycle:
//
//    authController defined in file [/Users/ashishsrivastava/Documents/java learning/hms/target/classes/com/ash/hms/controllers/AuthController.class]
//            ┌─────┐
//            |  userService defined in file [/Users/ashishsrivastava/Documents/java learning/hms/target/classes/com/ash/hms/services/UserService.class]
//            ↑     ↓
//            |  authenticationManager defined in class path resource [com/ash/hms/config/WebSecurityConfig.class]
//            └─────┘
//
//
//    Action:
//
//    Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.


//    Process finished with exit code 1

//    to avoid the above error we are using login in other service


//    READ THIS

//    why circular error was coming ?
//
//    Let's walk through it step by step.
//
//    Your class:
//
//    @Service
//    @RequiredArgsConstructor
//    public class UserService implements UserDetailsService {
//
//        private final AuthenticationManager authenticationManager;
//    }
//
//    and your config:
//
//    @Bean
//    AuthenticationManager authenticationManager(
//            AuthenticationConfiguration config)
//            throws Exception {
//        return config.getAuthenticationManager();
//    }
//    What Spring does during startup
//    Step 1
//
//    Spring sees:
//
//    @Service
//    public class UserService
//
//and tries to create a UserService bean.
//
//    To create it, Spring needs:
//
//    UserRepository
//            ModelMapper
//    PasswordEncoder
//    AuthenticationManager  ← important
//            JwtService
//
//    So Spring says:
//
//    Before I can create UserService,
//    I must create AuthenticationManager.
//    Step 2
//
//    Spring starts creating:
//
//    AuthenticationManager
//
//    using:
//
//            config.getAuthenticationManager()
//    Step 3
//
//    Spring Security now asks:
//
//    How should I authenticate users?
//    Who is my UserDetailsService?
//
//    It scans the context and finds:
//
//    @Service
//    public class UserService implements UserDetailsService
//
//So it decides:
//
//    UserService is my UserDetailsService
//    Step 4
//
//    To build the AuthenticationManager, Spring now needs:
//
//    UserService
//
//    But wait...
//
//    Spring was already trying to create UserService and got stuck because it needed AuthenticationManager.
//
//    Now we have:
//
//    Create UserService
//    ↓
//    Need AuthenticationManager
//    ↓
//    Need UserService
//    ↓
//    Need AuthenticationManager
//    ↓
//    Need UserService
//    ↓
//            ...
//
//    This is a circle.
//
//    Visual diagram
//    UserService
//      ↓
//    AuthenticationManager
//      ↓
//    UserDetailsService
//      ↓
//    UserService
//
//    Spring cannot decide which bean to create first.
//
//    Real-world analogy
//
//    Imagine:
//
//    Ashish needs Rahul's signature
//    Rahul needs Ashish's signature
//
//    Neither can proceed first.
//
//    That's exactly what happened.
//
//    Why commenting methods didn't help
//
//    You commented:
//
//    public String login(...)
//
//    but the problem was never inside login().
//
//    The problem was this field:
//
//    private final AuthenticationManager authenticationManager;
//
//    Because of @RequiredArgsConstructor, Spring still had to inject it during bean creation.
//
//            Even if you never called:
//
//            authenticationManager.authenticate(...)
//
//    the dependency already existed.
//
//    Why separating UserDetailsService fixes it
//
//    Instead of:
//
//    UserService
//    ↔
//    AuthenticationManager
//
//    you create:
//
//    @Service
//    class CustomUserDetailsService
//            implements UserDetailsService
//
//Now:
//
//    AuthenticationManager
//      ↓
//    CustomUserDetailsService
//
//            UserService
//      ↓
//    AuthenticationManager
//
//    No cycle anymore.
//
//    Each bean can be created independently.
//
//    The key insight is:
//
//    A circular dependency error happens during bean creation, not during method execution.
//
//    Spring never reached your login() method. It failed while building the object graph at application startup.

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public String login (LoginDto loginDto) {
        UserEntity user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail() , loginDto.getPassword())
        );

        UserEntity authUser = (UserEntity) authentication.getPrincipal();
        assert authUser != null;

        String token = jwtService.generateToken(authUser);
        System.out.println(authUser.getEmail());
        System.out.println(token);
        return token;
    }
}
