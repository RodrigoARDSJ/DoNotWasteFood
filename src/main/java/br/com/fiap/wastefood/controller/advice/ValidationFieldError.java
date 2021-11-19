package br.com.fiap.wastefood.controller.advice;



import lombok.Data;

@Data
public class ValidationFieldError {

	private String field;
	private String error;

	public ValidationFieldError(String field, String error) {
		this.field = field;
		this.error = error;
	}

}
