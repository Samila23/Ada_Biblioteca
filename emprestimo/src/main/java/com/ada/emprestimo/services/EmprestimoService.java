package com.ada.emprestimo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ada.emprestimo.dtos.EmprestimoDtoCadastro;
import com.ada.emprestimo.model.Cliente;
import com.ada.emprestimo.model.Emprestimo;
import com.ada.emprestimo.model.Livro;
import com.ada.emprestimo.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	@Autowired
	ClienteService clienteService;
	
	public EmprestimoDtoCadastro save(Emprestimo emprestimo) {
		//emprestimo.getCliente().getEmprestimo();
		clienteService.getOne(101);
		
		return emprestimoRepository.save(emprestimo).toEmprestimoDtoCadastro();
	}
	
}
