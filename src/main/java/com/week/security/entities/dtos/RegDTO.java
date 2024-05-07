package com.week.security.entities.dtos;

import java.io.Serializable;

import com.week.security.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	private UserRole role;
}
