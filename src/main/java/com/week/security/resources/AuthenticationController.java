package com.week.security.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.week.security.entities.User;
import com.week.security.entities.dtos.AuthDTO;
import com.week.security.entities.dtos.LoginResponseDTO;
import com.week.security.entities.dtos.RegDTO;
import com.week.security.repositories.UserRepository;
import com.week.security.services.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository repository;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/Login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthDTO login){
		var userPassword = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
		System.out.println(userPassword);
		var auth = this.authenticationManager.authenticate(userPassword);  
		var token = tokenService.generateToken((User)auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/Register")
	public ResponseEntity<Void> register(@RequestBody RegDTO reg){
		if(repository.findByLogin(reg.getLogin()) != null) {
			return ResponseEntity.badRequest().build();
		}else {
			String encryptedPassword = new BCryptPasswordEncoder().encode(reg.getPassword());
			User user = new User(reg.getLogin(), encryptedPassword, reg.getRole());
			repository.save(user);
			return ResponseEntity.ok().build();
		}
	}
}
