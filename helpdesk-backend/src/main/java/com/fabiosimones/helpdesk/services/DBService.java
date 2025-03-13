package com.fabiosimones.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiosimones.helpdesk.domain.Chamado;
import com.fabiosimones.helpdesk.domain.Cliente;
import com.fabiosimones.helpdesk.domain.Tecnico;
import com.fabiosimones.helpdesk.domain.enums.Perfil;
import com.fabiosimones.helpdesk.domain.enums.Prioridade;
import com.fabiosimones.helpdesk.domain.enums.Status;
import com.fabiosimones.helpdesk.repositories.ChamadoRepository;
import com.fabiosimones.helpdesk.repositories.ClienteRepository;
import com.fabiosimones.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;


	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir César", "63656396504", "valdir@mail.com", "123");
		tec1.AddPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "65666968204", "torvalds@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
