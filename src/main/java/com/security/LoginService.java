package com.security;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.RadnikRepository;
import com.dto.RadnikDTO;
import com.models.Radnik;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	@Autowired
	RadnikRepository radnikRepository;
	
	public static final String KEY = "2456D";

	public String authorize(RadnikDTO radnikDTO) {
		Radnik radnik=radnikRepository.findByEmailAndPassword(radnikDTO.getEmail(), radnikDTO.getPassword());
		if(radnik!=null) {
			String jws = Jwts.builder().setIssuer(radnik.getIme())
					.setSubject(radnik.getEmail())
					.claim("name", radnik.getIme()+""+radnik.getPrezime())
					.setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
					.signWith( SignatureAlgorithm.HS256,KEY).compact();
			return jws;
		}
		return null;
	}
	
	public String getRadnikEmail(@RequestParam String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
		
		return jws.getBody().getSubject();
	}
	
	public boolean proveriToken(String token) {
		String userEmail = getRadnikEmail(token);
		return userEmail != null;
	}
}
