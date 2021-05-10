package com.treinamento.consultarcliente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.consultarcliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
Page<Cliente> findAll(Pageable pageable);
Page<Cliente> findAllByPrimeiroNomeContaining(String nome,Pageable pageable);

}
