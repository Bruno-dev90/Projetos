package com.bruno.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.cursomc.domain.Cliente;

public interface ClienteRepositoty extends JpaRepository<Cliente, Integer> {

}
