package com.entregagencia.services;

import java.util.List;

import com.entregagencia.dto.UsuarioDTO;
import com.entregagencia.models.Usuario;

public interface UsuarioService {
	
	List<Usuario> getAllUsuarios();
	
	Usuario getUsuarioById(Long id);
	
	Usuario saveUsuario(UsuarioDTO  usuarioDTO);
	
	Usuario updateUsuario(Long id, UsuarioDTO usuarioDTOUpdated);
	
	void  deleteById(Long id);
	
	void addRelationship(Long usuarioId, Long viagemId);

	

	List<Object> findAllRels();

	

	
	
	
	

}
