package br.com.fiap.donotestaefood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank(message = "Digite seu nome")
	private String nome;
	
	@NotBlank(message = "Digite seu documento!")
	private String docs;
	
	@NotBlank(message = "Digite seu numero para contato!")
	private String contato;

}
