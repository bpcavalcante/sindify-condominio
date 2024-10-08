package com.sindify.condominio.service;

import com.sindify.condominio.controller.exception.ControllerNotFoundException;
import com.sindify.condominio.dto.MoradorDTO;
import com.sindify.condominio.entities.Morador;
import com.sindify.condominio.repository.MoradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public Collection<MoradorDTO> listarMoradores() {
        var moradores = moradorRepository.findAll();
        return moradores.stream().map(this::toMoradorDTO).collect(Collectors.toList());
    }

    public MoradorDTO buscarMoradorPorId(Long id) {
        var morador = moradorRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Morador não encontrado"));
        return toMoradorDTO(morador);
    }

    public List<MoradorDTO> buscarMoradorPorNome(String nome) {
        var morador = moradorRepository.findByNomeContainingIgnoreCase(nome);
        return morador.stream().map(this::toMoradorDTO).collect(Collectors.toList());
    }

    public List<MoradorDTO> buscarMoradorPorCPF(String cpf) {
        var morador = moradorRepository.findByCpfStartingWith(cpf);
        return morador.stream().map(this::toMoradorDTO).collect(Collectors.toList());
    }

    public MoradorDTO cadastrarMorador(MoradorDTO moradorDTO) {
        var morador = moradorRepository.save(toMorador(moradorDTO));
        return toMoradorDTO(morador);
    }

    public MoradorDTO atualizarMorador(Long id, MoradorDTO moradorDTO) {
        Morador buscaMorador = moradorRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Morador não encontrado"));
//            buscaMorador.setId(moradorDTO.id());
        buscaMorador.setNome(moradorDTO.nome());
        buscaMorador.setDdd(moradorDTO.ddd());
        buscaMorador.setTelefone(moradorDTO.telefone());
        buscaMorador.setEmail(moradorDTO.email());
        buscaMorador.setProprietario(moradorDTO.proprietario());
        buscaMorador.setUnidade(moradorDTO.unidade());
        buscaMorador.setCpf(moradorDTO.cpf());
        buscaMorador.setDataNascimento(moradorDTO.dataNascimento());
        buscaMorador = moradorRepository.save(buscaMorador);

        return toMoradorDTO(buscaMorador);
    }

    public void excluirMorador(Long id) {
        moradorRepository.deleteById(id);
    }

    private MoradorDTO toMoradorDTO(Morador morador) {
        return new MoradorDTO(
                morador.getId(),
                morador.getNome(),
                morador.getDdd(),
                morador.getTelefone(),
                morador.getEmail(),
                morador.getProprietario(),
                morador.getUnidade(),
                morador.getCpf(),
                morador.getDataNascimento()
        );
    }

    private Morador toMorador(MoradorDTO moradorDTO) {
        return new Morador(
                moradorDTO.id(),
                moradorDTO.nome(),
                moradorDTO.ddd(),
                moradorDTO.telefone(),
                moradorDTO.email(),
                moradorDTO.proprietario(),
                moradorDTO.unidade(),
                moradorDTO.cpf(),
                moradorDTO.dataNascimento()
        );
    }
}
