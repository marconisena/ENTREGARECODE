package com.entregagencia.servicesimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entregagencia.dto.UsuarioDTO;
import com.entregagencia.models.Usuario;
import com.entregagencia.models.Viagem;
import com.entregagencia.repository.UsuarioRepository;
import com.entregagencia.repository.ViagemRepository;
import com.entregagencia.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private ModelMapper mp;

	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private ViagemRepository vr;
	

	@Override
	public List<Usuario> getAllUsuarios() {
		
		return ur.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		
		return ur.findById(id).orElseThrow(()-> new RuntimeException( "ID: " + id + "Not Found" ));
	}

	@Override
	public Usuario saveUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = mp.map(usuarioDTO, Usuario.class);
		
		return ur.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, UsuarioDTO usuarioDTOUpdated) {
		Usuario usuarioExists = ur.findById(id).orElseThrow(()-> new RuntimeException( "ID: " + id + "Not Found" ));
		usuarioExists.setNome(usuarioDTOUpdated.getNome());
		usuarioExists.setCpf(usuarioDTOUpdated.getCpf());
		usuarioExists.setEmail(usuarioDTOUpdated.getEmail());
		usuarioExists.setSenha(usuarioDTOUpdated.getSenha());
		usuarioExists.setTelefone(usuarioDTOUpdated.getTelefone());
		
		
		
		return ur.save(usuarioExists);
	}

	@Override
	public void deleteById(Long id) {
		ur.deleteById(id);
		
	}

	@Override
	public void addRelationship(Long usuarioId, Long viagemId) {
		Usuario usuario = ur.findById(usuarioId).orElseThrow(()-> new RuntimeException( "ID: " + usuarioId + "Not Found" ));
		Viagem viagem = vr.findById(viagemId).orElseThrow(()-> new RuntimeException( "ID: " + viagemId + "Not Found" ));
		
		if(usuario != null && viagem  != null) {
			usuario.getViagem().add(viagem);
			viagem.getUsuario().add(usuario);
			
			ur.save(usuario);
			vr.save(viagem);
		}
		
	}

	

	@Override
	public List<Object> findAllRels() {
		
		return ur.findAllRels();
	}

	




}
