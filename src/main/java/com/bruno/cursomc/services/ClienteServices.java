package com.bruno.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.cursomc.domain.Cliente;
import com.bruno.cursomc.repositories.ClienteRepository;

@Service
public class ClienteServices {
	
	@Autowired
	 private ClienteRepository repo;

	public Cliente buscar (Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), null)); 
	}
	
}
