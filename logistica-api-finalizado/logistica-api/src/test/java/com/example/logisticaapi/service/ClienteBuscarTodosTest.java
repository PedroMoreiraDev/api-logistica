package com.example.logisticaapi.service;


import com.example.logisticaapi.domain.model.Cliente;
import com.example.logisticaapi.domain.repository.ClienteRepository;
import com.example.logisticaapi.domain.service.CatalogoClienteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_cliente_buscar_todos.sql")

public class ClienteBuscarTodosTest {

    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void buscarTodosClientesTest(){

        List<Cliente> listaClientes = catalogoClienteService.buscarTodosCliente();
        List<Cliente> listaClienteDaBase = clienteRepository.findAll();

        Cliente clienteService =listaClientes.stream()
                .filter(client -> client.getNome().equals("pedro")).findFirst().get();

        Cliente clienteDaBase = listaClienteDaBase.stream()
                .filter(client -> client.getNome().equals("pedro")).findFirst().get();

        assertNotNull(Objects.nonNull(listaClientes));
        assertEquals(clienteDaBase.getNome(), clienteService.getNome());
        assertEquals(clienteDaBase.getId(),clienteService.getId());
    }
}
