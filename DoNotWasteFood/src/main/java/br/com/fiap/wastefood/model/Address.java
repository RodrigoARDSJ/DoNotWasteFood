package br.com.fiap.wastefood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Logradouro não pode estar vaizo!")
	private String logradouro;
	
	@NotBlank(message = "CEP não pode estar vazia!")
	private String cep;
	
	@NotBlank(message = "cidade não pode estar vazia!")
	private String cidade;
	
	

}
