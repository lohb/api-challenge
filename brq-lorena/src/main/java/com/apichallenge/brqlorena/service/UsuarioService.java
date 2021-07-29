package com.apichallenge.brqlorena.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apichallenge.brqlorena.model.Usuario;
import com.apichallenge.brqlorena.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> listar() {
		return repository.findAll();
	}

	public Usuario obter(long id) {
		return repository.findById(id);
	}
	
	/*public ResponseEntity<Usuario> obter(long id) {

		if (id < 0) {
			ResponseEntity.badRequest().build();
		}
		Usuario usuario = this.usuarioRepository.findById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}*/

	public Usuario salvar(Usuario usuario) {

		if (usuario == null) {
			throw new NoSuchElementException("Usuário não pode ser null;");
		}

		return this.repository.save(usuario);
	}

	public void excluir(Usuario usuario) {
		this.repository.delete(usuario);
	}

	public Usuario editar(Usuario usuario) {

		if (usuario == null) {
			throw new NoSuchElementException("Usuário não pode ser null;");
		}
		
		return this.repository.save(usuario);
	}
	
}
