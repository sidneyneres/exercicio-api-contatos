package br.com.santander.dto;

import br.com.santander.model.Email;

public class EmailDto {

	private Integer id;
	private String email;
	
	public EmailDto(Email email) {
		this.id = email.getId();
		this.email = email.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	
	
}
