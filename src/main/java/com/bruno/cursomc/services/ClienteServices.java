package com.bruno.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bruno.cursomc.domain.Cliente;
import com.bruno.cursomc.dto.ClienteDTO;
import com.bruno.cursomc.repositories.ClienteRepository;
import com.bruno.cursomc.services.exception.DataIntegrityException;

@Service
public class ClienteServices {
	
	@Autowired
	 private ClienteRepository repo;

	public Cliente find (Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), null)); 
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {	
			repo.deleteById(id);	
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possivel excluir porque há entidades relacionadas");
		}
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}	
	
	public Page <Cliente> findPage(Integer page, Integer linesPerPage, 
			String orderBy, String direction){
		PageRequest pagerequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pagerequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
  		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
  	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
}
