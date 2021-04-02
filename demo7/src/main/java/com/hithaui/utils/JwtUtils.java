package com.hithaui.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
	@Value("${jwt.secret_key}")
	private String SECRET_KEY;
	
	public String extracUsername(String jwt) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getSubject();
	}
	

	public Date extracExpiration(String jwt) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getExpiration();
	}
	
	
	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()+3000))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
		
	}

}
