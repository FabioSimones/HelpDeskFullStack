package com.fabiosimones.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiosimones.helpdesk.domain.Pessoa;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findByCpf(String cpf);
    Optional<Pessoa> findByEmail(String email);

}
