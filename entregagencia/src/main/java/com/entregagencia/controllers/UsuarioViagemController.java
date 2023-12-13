package com.entregagencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entregagencia.dto.UsuarioViagemDTO;
import com.entregagencia.services.UsuarioService;

@RestController
@RequestMapping("/usuariolviagem")
public class UsuarioViagemController {
	
	
	@Autowired
	private UsuarioService ur;
	
	@PostMapping("/addusuarioviagem")
	public ResponseEntity<String> addRelationship(@RequestBody UsuarioViagemDTO urDTO){
		ur.addRelationship(urDTO.getUsuarioId(), urDTO.getViagemId());
		return new ResponseEntity<>("Relationhip created", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/findallrels")
	public List<Object> getAllRels(){
		
		
		return ur.findAllRels();
	}
	
	

}
