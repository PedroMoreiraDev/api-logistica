package com.example.logisticaapi.domain.repository;

import com.example.logisticaapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
//criando find que pesquisa pelo nome e pesquisa se contem alguma parte do nome
//    List<Cliente> findByNome(String nome);
//    List<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail(String email);

}
