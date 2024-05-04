package com.week.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week.security.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
