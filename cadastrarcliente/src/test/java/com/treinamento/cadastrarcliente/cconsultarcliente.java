package com.treinamento.cadastrarcliente;

public class cconsultarcliente {
	package br.com.gft.demo.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.PatchMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import br.com.gft.demo.entity.Cliente;
	import br.com.gft.demo.entity.Salario;
	import br.com.gft.demo.service.impl.ClienteServiceImpl;

	@RestController
	@RequestMapping("/clientes")
	public class ClienteController {

		@Autowired
		private ClienteServiceImpl service;

		Cliente getCliente;

		Cliente getClienteSalario;
		
		@PutMapping
		public ResponseEntity<?> update(@RequestParam Integer id, @RequestBody Cliente cliente) {
			getCliente = service.getCliente(id);

			if (getCliente == null) {
				save(cliente);
				return ResponseEntity.ok().body("Cliente salvo na Base de Dados "+ cliente.getId());
			} else {
				update(getCliente, cliente);
				System.out.println("Id para alterar salario "+cliente.getId());
				return ResponseEntity.ok(HttpStatus.CREATED).ok(cliente);
			}


		}

		@PatchMapping
		public ResponseEntity<?> update(@RequestParam Integer id, @RequestBody Salario salario) {
			getClienteSalario = service.getCliente(id);

			if (getClienteSalario != null && (salario != null && salario.getSalario() > 0)) {
				getClienteSalario.setSalario(salario.getSalario());
				service.saveCliente(getClienteSalario);
				return ResponseEntity.ok().body(getClienteSalario);
			}else {
				return ResponseEntity.ok().body("Dados nao encontrado");	
			}

		}

		@DeleteMapping
		public ResponseEntity<?> delete(@RequestParam Integer id) {
			getCliente = service.getCliente(id);

			if (getCliente != null) {
				service.delete(getCliente.getId());
				return ResponseEntity.ok().body("Cliente Removido com sucesso");
			}else {
				return ResponseEntity.ok().body("Dados nao encontrado");	
			}

		}
		
		public void save(Cliente cliente) {
			service.saveCliente(cliente);
		}

		public void update(Cliente getCliente, Cliente cliente) {
			getCliente.setId(getCliente.getId());
			getCliente.setCpf(cliente.getCpf());
			getCliente.setDataNascimento(cliente.getDataNascimento());
			getCliente.setSexo(cliente.getSexo());
			getCliente.setPrimeiroNome(cliente.getPrimeiroNome());
			getCliente.setProfissao(cliente.getProfissao());
			getCliente.setUltimoNome(cliente.getPrimeiroNome());
			getCliente.setSalario(cliente.getSalario());

			service.saveCliente(cliente);
		}
	}

}
