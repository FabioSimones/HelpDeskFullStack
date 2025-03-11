package com.fabiosimones.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiosimones.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
