package com.example.logisticaapi.service;

import com.example.logisticaapi.domain.model.Cliente;
import com.example.logisticaapi.domain.repository.ClienteRepository;
import com.example.logisticaapi.domain.service.CatalogoClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
@WebAppConfiguration
@Sql(scripts = "/sql/insert_cliente_buscar_e_deletar_por_id.sql")
//@RunWith(SpringRunner.class)
public class ClienteBuscareDeletarPorIdTest {



        @Autowired
        private CatalogoClienteService catalogoClienteService;

        @Autowired
        ClienteRepository clienteRepository;

        @Test
        void buscarClienteTest() {
            Cliente cliente = catalogoClienteService.buscar(55L);

            assertEquals("pedro", cliente.getNome());
            assertEquals("pedro123@gmail.com", cliente.getEmail());
        }

        @Test
        public void deletaPorIdTest(){
            catalogoClienteService.excluir(55L);

            Optional<Cliente> optionalCliente = clienteRepository.findById(55L);

            assertFalse(optionalCliente.isPresent());
        }


}
