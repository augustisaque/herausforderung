package com.example.tsystems.endpoint.controller;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.tsystems.endpoint.service.PessoaService;
import com.example.tsystems.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/admin/pessoas")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {
	private final PessoaService pessoaService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/list/", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Pessoa>> list(Pageable pageable) {
		log.info("Controller...");
		return new ResponseEntity<>(pessoaService.list(pageable), HttpStatus.OK);
	}

	@PostMapping("v1/admin/pessoas")
	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok().body(pessoaService.save(pessoa));
	}

	@PutMapping("/v1/admin/pessoas/{id}")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody Pessoa pessoaDetalhes) {
		Optional<Pessoa> pessoa = pessoaService.findByIdPessoa(id);
		if (pessoa == null)
			return ResponseEntity.notFound().build();
		BeanUtils.copyProperties(pessoaDetalhes, pessoa, "id");
		Pessoa  attPessoa = pessoaService.save(pessoa.get());
		return ResponseEntity.ok().body(attPessoa);
	}

	@DeleteMapping("v1/admin/pessoas/{id}")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<Pessoa> delete(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaService.findByIdPessoa(id);
		if (pessoaService == null)
			return ResponseEntity.notFound().build();
		pessoaService.deleteById(pessoa.get().getId());
		return ResponseEntity.ok().build();
	}

}
