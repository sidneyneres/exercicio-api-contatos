package br.com.santander.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.santander.model.TipoTelefone;

public class ContatoForm {

	@NotNull
	private String nome;
	@NotNull
	private String numeroTel;

	private String sobrenome;
	private String apelido;
	private LocalDate dataNiver;
	private Integer ddd;
	private TipoTelefone tipoTel;
	private String nomeRua;
	private String numeroCasa;
	private String bairro;
	private String cidade;
	private String uf;
	private String email;
	private String cep;

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public LocalDate getDataNiver() {
		return dataNiver;
	}

	public Integer getDdd() {
		return ddd;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public TipoTelefone getTipoTel() {
		return tipoTel;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getEmail() {
		return email;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCep() {
		return cep;
	}

}
