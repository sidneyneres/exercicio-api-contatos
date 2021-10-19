package br.com.santander.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String apelido;
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "contato")
	private List<Telefone> telefone = new ArrayList<>();

	@OneToMany(mappedBy = "contato")
	private List<Endereco> endereco = new ArrayList<>();

	@OneToMany(mappedBy = "contato")
	private List<Email> email = new ArrayList<>();

	public Contato() {
	}

	public Contato(String nome, String sobreNome, String apelido, LocalDate dataNascimento) {
		this.nome = nome;
		this.sobrenome = sobreNome;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
	}

	public Contato(String nomeContato, Telefone telefoneContato) {
		this.nome = nomeContato;
		this.telefone = new ArrayList<>();
	}

	public Contato(String nome, String sobrenome, String apelido, LocalDate dataNiver, List<Telefone> telefone,
			List<Endereco> endereco, List<Email> email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.dataNascimento = dataNiver;
		this.telefone = new ArrayList<>();
		this.endereco = endereco;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobrenome;
	}

	public String getApelido() {
		return apelido;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public List<Email> getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobrenome = sobreNome;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", apelido=" + apelido
				+ ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	
}
