package com.sindify.condominio.service.validation;

import com.sindify.condominio.controller.exception.ControllerNotFoundException;
import com.sindify.condominio.dto.MoradorDTO;
import com.sindify.condominio.entities.Morador;
import com.sindify.condominio.repository.MoradorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CriacaoMoradorValidator implements ConstraintValidator<CriacaoMoradorValid, MoradorDTO> {

    @Autowired
    private MoradorRepository repository;

    @Override
    public void initialize(CriacaoMoradorValid annotation) {}

    @Override
    public boolean isValid(MoradorDTO moradorDTO, ConstraintValidatorContext context) {
        Optional<Morador> morador = repository.findByEmail(moradorDTO.email());
        return morador.isEmpty();
    }

}
