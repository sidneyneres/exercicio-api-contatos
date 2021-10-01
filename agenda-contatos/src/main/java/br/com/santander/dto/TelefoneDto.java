package br.com.santander.dto;

import br.com.santander.model.Telefone;
import br.com.santander.model.TipoTelefone;

public class TelefoneDto {

	private Integer id;
	private Integer ddd;
	private TipoTelefone tipo;
	private String numero;
	
	public TelefoneDto(Telefone telefone) {
		this.id = telefone.getId();
		this.ddd = telefone.getDdd();
		this.tipo = telefone.getTipo();
		this.numero = telefone.getNumero();
	}

	public TelefoneDto(Integer id, Integer ddd, TipoTelefone tipo, String numeroTel) {
		this.id = id;
		this.ddd = ddd;
		this.tipo = tipo;
		this.numero = numeroTel;
	}

	public Integer getId() {
		return id;
	}

	public Integer getDdd() {
		return ddd;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}
	
	
}
