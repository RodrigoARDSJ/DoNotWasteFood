package br.com.fiap.donotestaefood.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class PontoDeColeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Estoque de alimento vazio!")
	private BigDecimal estoqueDeAlimento;
	
	@NotBlank(message = "Coloque um endereço!")
	private String rua;
	
	@NotBlank(message = "Digite o numero do local")
	private String numRua;
	
	@NotBlank(message = "Digite a data de entrega!")
	@Temporal(TemporalType.DATE)
	private Date dataDeEntrega;
	
	@NotBlank(message = "Digite o tipo de alimento!")
	private String tipoDeAlimento;

}
