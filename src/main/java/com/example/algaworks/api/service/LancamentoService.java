package com.example.algaworks.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algaworks.api.model.Lancamento;
import com.example.algaworks.api.model.Pessoa;
import com.example.algaworks.api.repository.LancamentoRepository;
import com.example.algaworks.api.repository.PessoaRepository;
import com.example.algaworks.api.service.exception.PessoaInexistenteOuInativoException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	private Optional<Pessoa> pessoaOpt;

	private Pessoa pessoa;

	public Lancamento salvar(Lancamento lancamento) throws PessoaInexistenteOuInativoException {
		pessoaOpt = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		pessoa = pessoaOpt.get();
		if (pessoa != null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativoException();
		}
		return lancamentoRepository.save(lancamento);
	}
}
