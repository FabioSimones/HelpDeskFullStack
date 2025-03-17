package com.fabiosimones.helpdesk.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fabiosimones.helpdesk.domain.Pessoa;
import com.fabiosimones.helpdesk.domain.dtos.TecnicoDTO;
import com.fabiosimones.helpdesk.repositories.PessoaRepository;
import com.fabiosimones.helpdesk.services.exceptions.DataIntegrityViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiosimones.helpdesk.domain.Tecnico;
import com.fabiosimones.helpdesk.repositories.TecnicoRepository;
import com.fabiosimones.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

    public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return tecnicoRepository.save(newObj);
    }

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return tecnicoRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if(obj.getChamados().size() > 0){
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço, não podendo ser deletado!");
		}

		tecnicoRepository.deleteById(id);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())){
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}

		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())){
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}
}
