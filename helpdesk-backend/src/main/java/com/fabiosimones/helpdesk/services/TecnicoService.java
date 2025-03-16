package com.fabiosimones.helpdesk.services;

import java.util.List;
import java.util.Optional;

import com.fabiosimones.helpdesk.domain.dtos.TecnicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiosimones.helpdesk.domain.Tecnico;
import com.fabiosimones.helpdesk.repositories.TecnicoRepository;
import com.fabiosimones.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

    public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		Tecnico newObj = new Tecnico(objDTO);
		return tecnicoRepository.save(newObj);
    }
}
