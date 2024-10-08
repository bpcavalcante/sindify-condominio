package com.sindify.condominio.dto;

import com.sindify.condominio.service.validation.CriacaoMoradorValid;
import java.time.LocalDate;

@CriacaoMoradorValid(message = "E-mail já cadastrado")
public record MoradorDTO(
        Long id,
        String nome,
        String ddd,
        String telefone,
        String email,
        Boolean proprietario,
        String unidade,
        String cpf,
        LocalDate dataNascimento) {
}
