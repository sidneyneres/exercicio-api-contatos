package br.com.santander.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.santander.model.Contato;
import br.com.santander.model.Email;
import br.com.santander.model.Endereco;
import br.com.santander.model.Telefone;
import br.com.santander.model.TipoTelefone;
import br.com.santander.repository.ContatoRepository;
import br.com.santander.repository.EmailRepository;
import br.com.santander.repository.EnderecoRepository;
import br.com.santander.repository.TelefoneRepository;

public class ContatoFormAtlz {

	@NotNull
	@NotEmpty
	private String nome;
	private String sobrenome;
	private String apelido;
	private LocalDate aniversario;
	private Integer ddd;
	@NotNull
	@NotEmpty	
	private String telefone;
	private TipoTelefone tipo;
	private String email;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private String bairro;
	private String uf;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public void setAniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Contato atualizar(Integer id, ContatoRepository contatoRepository, TelefoneRepository telefoneRepository,
			EmailRepository emailRepository, EnderecoRepository enderecoRepository) {
		Contato contato = contatoRepository.getById(id);
		Telefone telefone = telefoneRepository.getById(id);
		Email email = emailRepository.getById(id);
		Endereco endereco = enderecoRepository.getById(id);
		contato.setNome(this.nome);
		contato.setSobreNome(this.sobrenome);
		contato.setApelido(this.apelido);
		contato.setDataNascimento(this.aniversario);

		telefone.setDdd(this.ddd);
		telefone.setNumero(this.telefone);
		telefone.setTipo(this.tipo);

		email.setEmail(this.email);

		endereco.setLogradouro(this.logradouro);
		endereco.setNumero(this.numero);
		endereco.setBairro(this.bairro);
		endereco.setCep(this.cep);
		endereco.setCidade(this.cidade);
		endereco.setUf(this.uf);
		
		return contato;
	}

}
