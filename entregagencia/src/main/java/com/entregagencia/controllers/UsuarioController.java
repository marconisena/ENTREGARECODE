package com.entregagencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entregagencia.dto.UsuarioDTO;
import com.entregagencia.models.Usuario;
import com.entregagencia.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	
	@Autowired
	private UsuarioService ur;
	
	@PostMapping("/saveusuario")
	public Usuario createUsuario(@RequestBody UsuarioDTO usuarioDto) {
		
		return ur.saveUsuario(usuarioDto);
	}
	@GetMapping("/allusuarios")
	public List<Usuario> getAllUsuarios(){
		
		return ur.getAllUsuarios();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Long id){
		Usuario usuario = ur.getUsuarioById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDTOUpdated){
		Usuario usuario = ur.getUsuarioById(id);
		
		usuario.setNome(usuarioDTOUpdated.getNome());
		usuario.setCpf(usuarioDTOUpdated.getCpf());
		usuario.setEmail(usuarioDTOUpdated.getEmail());
		usuario.setSenha(usuarioDTOUpdated.getSenha());
		usuario.setTelefone(usuarioDTOUpdated.getTelefone());
		
		ur.updateUsuario(id, usuarioDTOUpdated);
		return  ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		ur.deleteById(id);
	}
}
