package com.example.logisticaapi.api.controller;

import com.example.logisticaapi.domain.model.Cliente;
import com.example.logisticaapi.domain.repository.ClienteRepository;
import com.example.logisticaapi.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {



    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();

    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
      return clienteRepository.findById(clienteId)
//              .map(cliente -> ResponseEntity.ok(cliente))
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    }


        //        ====================================== pesquisando por id modo longo =======================

//    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){

//        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//
//        if(cliente.isPresent()) {
//            return ResponseEntity.ok(cliente.get());
//        }
//
//        return ResponseEntity.notFound().build();
//    }


//        ====================================== pesquisando por nome especifico =======================
    //
//    @GetMapping("/clientes")
//    public List<Cliente> listar(){
//        return clienteRepository.findByNome("pedro");
//
//    }

    //pesquisando por nome que contem determinado char
//    @GetMapping("/clientes")
//    public List<Cliente> listar(){
//        return clienteRepository.findByNomeContainig("pe");
//
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
    return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente){
    if(!clienteRepository.existsById(clienteId)){
        return ResponseEntity.notFound().build();
    }
    cliente.setId(clienteId);;
    cliente = catalogoClienteService.salvar(cliente);
    return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover (@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        catalogoClienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();
    }
}
