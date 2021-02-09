package com.example.tsystems.endpoint.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.tsystems.model.Pessoa;
import com.example.tsystems.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
	private final PessoaRepository pessoaRepository;
	
	public Iterable<Pessoa> list(Pageable pageable) {
		log.info("Listing all people");
		return pessoaRepository.findAll(pageable);
	}
	
	public Pessoa save(Pessoa pessoa){
		return pessoaRepository.save(pessoa);
	}
	
	public Optional<Pessoa> findByIdPessoa(Long id) {
		return pessoaRepository.findById(id);
	}
	public void deleteById(Long id) {
		pessoaRepository.deleteById(id);
	}
}
