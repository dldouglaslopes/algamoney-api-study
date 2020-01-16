package com.example.algaworks.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algaworks.api.model.Pessoa;
import com.example.algaworks.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	public PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
		Pessoa pessoaSalva2 = pessoaSalva.get();
		if (pessoaSalva2 == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(pessoa, pessoaSalva2, "codigo");
		pessoaRepository.save(pessoaSalva2);
		
		return pessoaSalva2;
	}
}
