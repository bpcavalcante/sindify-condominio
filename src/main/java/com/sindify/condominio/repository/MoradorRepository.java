package com.sindify.condominio.repository;

import com.sindify.condominio.entities.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

    List<Morador> findByNomeContainingIgnoreCase(String nome);

    List<Morador> findByCpfStartingWith(String cpf);

    Optional<Morador> findByEmail(String email);
}
