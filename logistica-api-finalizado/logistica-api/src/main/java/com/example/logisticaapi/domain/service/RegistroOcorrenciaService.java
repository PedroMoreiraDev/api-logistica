package com.example.logisticaapi.domain.service;

import com.example.logisticaapi.domain.exception.NegocioExeption;
import com.example.logisticaapi.domain.model.Entrega;
import com.example.logisticaapi.domain.model.Ocorrencia;
import com.example.logisticaapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
    return entrega.adicionarOcorrencia(descricao);
    }
}
