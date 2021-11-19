package br.com.fiap.donotestaefood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Addres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "CEP não pode ser vazio!")
	private String CEP;
	
	@NotBlank(message = "Cidade não pode ser vazio!")
	private String cidade;
	
	@NotBlank(message = "Logradouro não pode ser vazio!")
	private String logradouro;
}
