package com.week.security.entities.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	
}
