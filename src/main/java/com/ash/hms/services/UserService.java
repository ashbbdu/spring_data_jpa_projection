package com.ash.hms.services;

import com.ash.hms.dto.LoginDto;
import com.ash.hms.dto.SignupDto;
import com.ash.hms.dto.UserDetailsDto;
import com.ash.hms.dto.UserDto;
import com.ash.hms.entities.UserEntity;
import com.ash.hms.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@NullMarked
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new NoSuchElementException("User not found !"));
    }

    public UserDto createUser (SignupDto signupDto) {
        UserEntity user = modelMapper.map(signupDto , UserEntity.class);
//        user.setEmail(signupDto.getEmail());
//        user.setName(signupDto.getName());
//        user.setPassword(signupDto.getPassword());

        String encodedPassword = passwordEncoder.encode(signupDto.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return modelMapper.map(user , UserDto.class);

    }


}
