package com.ada.livro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.livro.model.Livro;
import com.ada.livro.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository livroRepository;
	
	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}
	public List<Livro> getAll(){
		return livroRepository.findAll();
	}
	
	public Livro getOne(int id) {
		return livroRepository.findById(id).orElse(new Livro());
	}
	
	public Livro update(int id, Livro livro) {
		Optional<Livro> optional = livroRepository.findById(id);
		if (optional.isPresent() == true){ 
			Livro livroBD = optional.get();
			 
			return livroRepository.save(livroBD); 
		}
		else {
			return new Livro();
		}
	}
	
	public Livro updateEstoque(int id, int quantidade, int tipoTransacao) { 
		Livro livro = new Livro();
		Optional<Livro> optional = livroRepository.findById(id);
		if (optional.isPresent() == true){
			Livro livroBD = optional.get();
			if(tipoTransacao == 1) {
				//Devolucao
				livroBD.setQuantidade(livro.getQuantidade() + quantidade);
			}
			else {
				//Emprestimo
				livroBD.setQuantidade(livro.getQuantidade() - quantidade);
			}
			livroBD.setQuantidade(livro.getQuantidade());
			return livroRepository.save(livroBD); 
		}
		else {
			return new Livro();
		}
	}
	
	public void delete(int id) {
		livroRepository.deleteById(id);
	}
}
