package com.fabiosimones.helpdesk.services;

import com.fabiosimones.helpdesk.domain.Pessoa;
import com.fabiosimones.helpdesk.domain.Cliente;
import com.fabiosimones.helpdesk.domain.dtos.ClienteDTO;
import com.fabiosimones.helpdesk.repositories.PessoaRepository;
import com.fabiosimones.helpdesk.repositories.ClienteRepository;
import com.fabiosimones.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.fabiosimones.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

    public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return clienteRepository.save(newObj);
    }

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		if(!objDTO.getSenha().equals(oldObj.getSenha())){
			objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		}
		validaPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return clienteRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getChamados().size() > 0){
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço, não podendo ser deletado!");
		}

		clienteRepository.deleteById(id);
	}

	private void validaPorCpfEEmail(ClienteDTO objDTO) {
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
