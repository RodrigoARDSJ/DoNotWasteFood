package br.com.fiap.wastefood.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_USER")
public class User {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{user.name.blank}")
	private String name;
	
	@NotBlank(message = "{user.docs.invalid}")
	private String docs;
	
	@NotBlank(message = "{user.contato.invalid}")
	private String contato;
	
	@NotBlank(message = "{user.email.blank}")
	@Email(message = "{user.email.invalid}")
	private String email;
	
	@Size(min = 8, message = "{user.password.size}")
	private String password;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public void setUsername(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
