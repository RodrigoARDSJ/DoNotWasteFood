package br.com.fiap.wastefood.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class CollectPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Min(value = 10 ,message = "Não pode ser vazio")
	private BigDecimal estoqueDeAlimento;

	
	@NotBlank(message = "Não pode ser vazio")
	private String tipoDeAlimento;
	
	@NotBlank(message = "Não pode ser vazio")
	private String rua;

}
