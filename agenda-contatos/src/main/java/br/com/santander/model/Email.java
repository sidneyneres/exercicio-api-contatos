package br.com.santander.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;

	@ManyToOne
	private Contato contato;

	public Email() {
	}

	public Email(String email, Contato contato) {
		this.email = email;
		this.contato = contato;
	}

	public Email(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", email=" + email + ", contato=" + contato + "]";
	}

}
