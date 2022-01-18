package com.example.logisticaapi.domain.service;

import com.example.logisticaapi.domain.exception.NegocioExeption;
import com.example.logisticaapi.domain.model.Cliente;
import com.example.logisticaapi.domain.model.Entrega;
import com.example.logisticaapi.domain.model.StatusEntrega;
import com.example.logisticaapi.domain.repository.ClienteRepository;
import com.example.logisticaapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }
}
