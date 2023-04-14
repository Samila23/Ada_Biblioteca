package com.ada.cliente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																						
@AllArgsConstructor 																		
@NoArgsConstructor 																			
@Entity 																					
@Table(name="CLIENTE") 																	
public class Cliente {
	
	@Id 																					
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
    private Integer id;
    private String nome;
    private Integer idade;
    private String telefone;
    private String endereco;
    private String email;
}
