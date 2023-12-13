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
import com.entregagencia.models.Viagem;
import com.entregagencia.services.ViagemService;


@RestController
@RequestMapping("/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemService vr;
	
	@PostMapping("/saveviagem")
	public Viagem createViagem(@RequestBody Viagem viagem) {
		
		return vr.saveViagem(viagem);
	}
	@GetMapping("/allviagems")
	public List<Viagem> getAllViagens(){
		
		return vr.getAllViagems();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Viagem> getViagem(@PathVariable Long id){
		Viagem viagem = vr.getViagemById(id);
		return ResponseEntity.ok(viagem);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Viagem> updateViagem(@PathVariable Long id,@RequestBody Viagem viagemUpdated){
		Viagem viagem = vr.getViagemById(id);
		
		viagem.setNome(viagemUpdated.getNome());
		
		vr.saveViagem(viagem);
		return  ResponseEntity.ok(viagem);
	}

	@DeleteMapping("/{id}")
	public void deleteViagem(@PathVariable Long id) {
		
		vr.deleteById(id);
	}

}
