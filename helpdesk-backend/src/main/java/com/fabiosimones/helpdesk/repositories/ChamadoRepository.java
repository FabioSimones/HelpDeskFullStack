package com.fabiosimones.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiosimones.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
