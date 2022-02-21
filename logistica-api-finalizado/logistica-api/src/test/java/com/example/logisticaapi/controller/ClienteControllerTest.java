package com.example.logisticaapi.controller;

import com.example.logisticaapi.api.controller.ClienteController;
import com.example.logisticaapi.domain.model.Cliente;
import com.example.logisticaapi.domain.repository.ClienteRepository;
import com.example.logisticaapi.domain.service.CatalogoClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ClienteController.class)
//@Sql(scripts = "/sql/insert_cliente_buscar_e_deletar_por_id.sql")
public class ClienteControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    CatalogoClienteService catalogoClienteService;

    @MockBean
    ClienteRepository clienteRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testandoGetAllController() throws Exception {
        Cliente cliente = new Cliente(177L, "pedro", "dfwefwe@dfwef", "545251");

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testandoPostController()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/clientes")).andExpect(status().isOk());}

}




















