package com.apichallenge.brqlorena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apichallenge.brqlorena.model.Usuario;
import com.apichallenge.brqlorena.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> obter(@PathVariable(value = "id") long id) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		Usuario usuario = service.obter(id);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@PostMapping(value = "/inserir")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(service.salvar(usuario));
	}

	@DeleteMapping(value = "/excluir")
	@ResponseStatus(HttpStatus.CREATED)
	public void delete(@RequestBody Usuario usuario) {
		service.excluir(usuario);
	}

	@PutMapping(value = "/editar")
	public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(service.editar(usuario));
	}

}
