package com.example.logisticaapi.domain.service;

import com.example.logisticaapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.logisticaapi.domain.exception.NegocioExeption;
import com.example.logisticaapi.domain.model.Entrega;
import com.example.logisticaapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service

public class BuscaEntregaService {
    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
            return entregaRepository.findById(entregaId)
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
        }
    }

