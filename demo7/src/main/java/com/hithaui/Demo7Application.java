package com.hithaui;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SpringBootApplication
public class Demo7Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo7Application.class, args);
		String username="haphong";
		final String SECURETY_KEY="abcdfasadafaaf";
		
//		String jwt= Jwts.builder()
//							.setSubject(username)
//							.setIssuedAt(new Date(System.currentTimeMillis()))
//							.setExpiration(new Date(System.currentTimeMillis()+99000))
//							.signWith(SignatureAlgorithm.HS256, SECURETY_KEY )
//							.compact();
//				
//		System.out.println(jwt);

		
		
//	String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXBob25nIiwiaWF0IjoxNjE2MjQyNDY5LCJleHAiOjE2MTYyNDI1Njh9.Qc-fuA5M3EQVzNITsY3UDGmSdauujNYB-ja0jRzS1PA";
//	String token =jwt;
//	String decode=Jwts.parser()
//						.setSigningKey(SECURETY_KEY)
//						.parseClaimsJws(token)
//						.getBody()
//						.getSubject();
//	System.out.println(decode);						
	
		PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		String hash=passwordEncoder.encode("phong");
		System.out.println(hash);
		
		
				
		
		
		
	}

}
