package com.example.algaworks.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algaworks.api.model.Lancamento;
import com.example.algaworks.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{
	
}
