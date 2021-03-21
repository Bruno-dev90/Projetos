package com.bruno.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
