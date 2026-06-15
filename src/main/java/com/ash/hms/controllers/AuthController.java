package com.ash.hms.controllers;

import com.ash.hms.dto.LoginDto;
import com.ash.hms.dto.SignupDto;
import com.ash.hms.dto.UserDto;
import com.ash.hms.services.AuthService;
import com.ash.hms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<UserDto> addUser (@RequestBody SignupDto signupDto) {
        UserDto user = userService.createUser(signupDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/login")
    public String login (@RequestBody LoginDto loginDto) {
      return authService.login(loginDto);
    }
}
