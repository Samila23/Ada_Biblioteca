package com.ada.emprestimo.dtos;

import org.modelmapper.ModelMapper;

import com.ada.emprestimo.model.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																											//Inclui todos os Gte e Set
@AllArgsConstructor 																							//Inclui os construtores com todos os paramentros
@NoArgsConstructor 
public class EmprestimoDtoCadastro {
	
    private ClienteCadastroDTO cliente;
    private LivroCadastroDto livro;
    
	public Emprestimo toModelEmprestimo() {											// Ele irá converter apenas os ATRIBUTOS em COMUM das CLASSES
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Emprestimo.class);
	}
}
