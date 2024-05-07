package com.week.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.week.security.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	UserDetails findByLogin(String login);
}
