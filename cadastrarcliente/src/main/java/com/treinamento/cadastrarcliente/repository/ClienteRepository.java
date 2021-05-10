package com.treinamento.cadastrarcliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.cadastrarcliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


}
