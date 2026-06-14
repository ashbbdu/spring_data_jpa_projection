package com.ash.hms;

import com.ash.hms.entities.UserEntity;
import com.ash.hms.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

@SpringBootTest
class HmsApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		UserEntity user = new UserEntity(4L , "ash@gmail.com" , "abcde");
		String token = jwtService.generateToken(user);
		System.out.println(token);
	}

}
