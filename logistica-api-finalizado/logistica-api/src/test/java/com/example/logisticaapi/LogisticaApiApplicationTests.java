package com.example.logisticaapi;

import com.example.logisticaapi.domain.model.Cliente;
import com.example.logisticaapi.domain.model.Entrega;
import com.example.logisticaapi.domain.repository.ClienteRepository;
import com.example.logisticaapi.domain.service.BuscaEntregaService;
import com.example.logisticaapi.domain.service.CatalogoClienteService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_nutri_para_teste_buscar_por_id.sql")
class LogisticaApiApplicationTests {

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
