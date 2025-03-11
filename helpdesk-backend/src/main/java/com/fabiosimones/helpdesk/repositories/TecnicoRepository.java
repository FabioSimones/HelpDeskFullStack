package com.fabiosimones.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiosimones.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
