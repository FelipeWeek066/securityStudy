package com.week.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week.security.entities.Client;
import com.week.security.repositories.ClientRepository;
import com.week.security.services.exceptions.ContentNotFound;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> client = repository.findById(id);
		return client.orElseThrow(() -> new ContentNotFound("client not found."));
	}
	
	public Client insert(Client client) {
		return repository.save(client);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public void update(Long id, Client newObj) {
		Client client = findById(id);
		updateClient(client, newObj);
		repository.save(client);
	}
	
	private void updateClient(Client oldClient, Client newClient) {
		oldClient.setName(newClient.getName());
		oldClient.setEmail(newClient.getEmail());
		oldClient.setPhone(newClient.getPhone());
	}
}
