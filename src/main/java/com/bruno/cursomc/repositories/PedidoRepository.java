package com.bruno.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
