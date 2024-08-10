package com.sindify.condominio.controller;

import com.sindify.condominio.dto.MoradorDTO;
import com.sindify.condominio.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @GetMapping
    public ResponseEntity<Collection<MoradorDTO>> buscarMoradores(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        Collection<MoradorDTO> moradores;
        if (nome != null && !nome.isEmpty()) {
            moradores = moradorService.buscarMoradorPorNome(nome);
        } else if (cpf != null && !cpf.isEmpty()) {
            moradores = moradorService.buscarMoradorPorCPF(cpf);
        } else {
            moradores = moradorService.listarMoradores();
        }
        return ResponseEntity.ok(moradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorDTO> buscarMoradorPorId(@PathVariable Long id) {
        MoradorDTO morador = moradorService.buscarMoradorPorId(id);
        return ResponseEntity.ok(morador);
    }

    @PostMapping
    public ResponseEntity<MoradorDTO> cadastrarMorador(@RequestBody MoradorDTO moradorDTO) {
        moradorDTO = moradorService.cadastrarMorador(moradorDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(moradorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoradorDTO> atualizarMorador(
            @PathVariable Long id,
            @RequestBody MoradorDTO moradorDTO) {
        moradorDTO = moradorService.atualizarMorador(id, moradorDTO);
        return ResponseEntity.ok(moradorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMorador(@PathVariable Long id) {
        moradorService.excluirMorador(id);
        return ResponseEntity.noContent().build();
    }

}
