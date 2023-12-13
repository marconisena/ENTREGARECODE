package com.entregagencia.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entregagencia.models.Viagem;
import com.entregagencia.repository.ViagemRepository;
import com.entregagencia.services.ViagemService;

@Service
public class ViagemServicesImpl implements ViagemService {

	@Autowired
	private ViagemRepository vr;
	

	@Override
	public List<Viagem> getAllViagems() {
		
		return vr.findAll();
	}

	@Override
	public Viagem getViagemById(Long id) {
		
		return vr.findById(id).orElseThrow(()-> new RuntimeException( "ID: " + id + "Not Found" ));
	}

	@Override
	public Viagem saveViagem(Viagem viagem) {
	
		return vr.save(viagem);
	}

	@Override
	public Viagem updateViagem(Long id, Viagem viagemUpdated) {
		Viagem viagemExists = vr.findById(id).orElseThrow(()-> new RuntimeException( "ID: " + id + "Not Found" ));
		viagemExists.setNome(viagemUpdated.getNome());
		
		
		
		
		return vr.save(viagemExists);
	}

	@Override
	public void deleteById(Long id) {
		vr.deleteById(id);
		
	}


}
