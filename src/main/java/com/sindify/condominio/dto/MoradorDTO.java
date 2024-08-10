package com.sindify.condominio.dto;

import java.time.LocalDate;

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
