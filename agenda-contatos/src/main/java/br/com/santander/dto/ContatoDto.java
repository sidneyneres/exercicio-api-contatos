package br.com.santander.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.santander.model.Contato;

public class ContatoDto {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String apelido;
	private LocalDate aniversario;
	private List<TelefoneDto> telefone;
	private List<EmailDto> email;
	private List<EnderecoDto> endereco;

	public ContatoDto() {
	}

	public ContatoDto(Contato contato) {
		this.id = contato.getId();
		this.nome = contato.getNome();
		this.sobrenome = contato.getSobreNome();
		this.apelido = contato.getApelido();
		this.aniversario = contato.getDataNascimento();
		this.telefone = new ArrayList<>();
		this.telefone.addAll(contato.getTelefone().stream().map(TelefoneDto::new).collect(Collectors.toList()));
		this.email = new ArrayList<>();
		this.email.addAll(contato.getEmail().stream().map(EmailDto::new).collect(Collectors.toList()));
		this.endereco = new ArrayList<>();
		this.endereco.addAll(contato.getEndereco().stream().map(EnderecoDto::new).collect(Collectors.toList()));
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public List<TelefoneDto> getTelefone() {
		return telefone;
	}

	public List<EmailDto> getEmail() {
		return email;
	}

	public List<EnderecoDto> getEndereco() {
		return endereco;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public LocalDate getAniversario() {
		return aniversario;
	}

	public static List<ContatoDto> converte(List<Contato> contato) {
		return contato.stream().map(ContatoDto::new).collect(Collectors.toList());
	}

}
