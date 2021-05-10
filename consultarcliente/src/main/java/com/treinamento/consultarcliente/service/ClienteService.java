package com.treinamento.consultarcliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.treinamento.consultarcliente.model.Cliente;
import com.treinamento.consultarcliente.repository.ClienteRepository;

public class ClienteService {
  
	@Autowired
	private ClienteRepository clienteRepository;
	public Page<Cliente> listAllCliente(Pageable page, String nome) {
		if(nome==null) {
			return clienteRepository.findAll(page);
		}
		return clienteRepository.findAllByPrimeiroNomeContaining(nome, page);
	}

	public Cliente getCliente(Integer id) {
		
		return clienteRepository.findById(id).get();
	}

}
