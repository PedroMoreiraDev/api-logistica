package com.example.logisticaapi.domain.service;

import com.example.logisticaapi.domain.exception.NegocioExeption;
import com.example.logisticaapi.domain.model.Entrega;
import com.example.logisticaapi.domain.model.StatusEntrega;
import com.example.logisticaapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;
    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);

    }
}
