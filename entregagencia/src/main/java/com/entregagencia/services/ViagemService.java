package com.entregagencia.services;

import java.util.List;

import com.entregagencia.models.Viagem;


public interface ViagemService  {
	
	
	
List<Viagem> getAllViagems();
	
	Viagem getViagemById(Long id);
	
	Viagem saveViagem(Viagem viagem);
	
	Viagem updateViagem(Long id, Viagem viagemUpdated);
	
	void  deleteById(Long id);
	
	

}
