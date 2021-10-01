package br.com.santander.dto;

import br.com.santander.model.Endereco;

public class EnderecoDto {
	
	private Integer id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private String bairro;
	private String uf;
	
	public EnderecoDto (Endereco endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.bairro = endereco.getBairro();
		this.uf = endereco.getUf();
	}

	public Integer getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getUf() {
		return uf;
	}
	
	

}
