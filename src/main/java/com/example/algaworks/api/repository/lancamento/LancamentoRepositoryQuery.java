package com.example.algaworks.api.repository.lancamento;

import java.util.List;

import com.example.algaworks.api.model.Lancamento;
import com.example.algaworks.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
