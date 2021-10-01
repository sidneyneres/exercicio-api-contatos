package br.com.santander.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer ddd;
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipo;
	private String numero;

	@ManyToOne
	private Contato contato;

	public Telefone() {
	}

	public Telefone(Integer ddd, String numero, TipoTelefone tipo, Contato contato) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.contato = contato;
	}

	public Telefone(String numeroTel, Contato contato) {
		this.numero = numeroTel;
		this.contato = contato;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

}
