package br.com.santander.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.dto.ContatoDto;
import br.com.santander.form.ContatoForm;
import br.com.santander.form.ContatoFormAtlz;
import br.com.santander.model.Contato;
import br.com.santander.model.Email;
import br.com.santander.model.Endereco;
import br.com.santander.model.Telefone;
import br.com.santander.repository.ContatoRepository;
import br.com.santander.repository.EmailRepository;
import br.com.santander.repository.EnderecoRepository;
import br.com.santander.repository.TelefoneRepository;

@RestController
@RequestMapping("/contato")
public class ContatoController {
	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EmailRepository emailRepository;

	@GetMapping
	public List<ContatoDto> listarContatos() {
		List<Contato> contato = contatoRepository.findAll();
		return ContatoDto.converte(contato);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContatoDto> exibirContato(@PathVariable Integer id) {
		Optional<Contato> optional = contatoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new ContatoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ContatoDto> salvarContato(@RequestBody @Valid ContatoForm contatoInput,
			UriComponentsBuilder uriBuilder) {		
		Contato contato = new Contato(contatoInput.getNome(), contatoInput.getSobrenome(), contatoInput.getApelido(),
				contatoInput.getDataNiver());
				
		contatoRepository.save(contato);

		Telefone telefoneContato = new Telefone(contatoInput.getDdd(), contatoInput.getNumeroTel(),
				contatoInput.getTipoTel(), contato);
		List<Telefone> telefone = new ArrayList<>();
		telefone.add(telefoneContato);
		telefoneRepository.saveAll(telefone);

		Endereco enderecoContato = new Endereco(contatoInput.getNomeRua(), contatoInput.getCep(),
				contatoInput.getNumeroCasa(), contatoInput.getCidade(), contatoInput.getBairro(), contatoInput.getUf(), contato);
		List<Endereco> endereco = new ArrayList<>();
		endereco.add(enderecoContato);
		enderecoRepository.saveAll(endereco);

		Email emailContato = new Email(contatoInput.getEmail(), contato);
		List<Email> email = new ArrayList<>();
		email.add(emailContato);
		emailRepository.saveAll(email);

		System.out.println("saida EMAIL: " + email.toString());
		

		URI uri = uriBuilder.path("/contato/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).body(new ContatoDto(contato));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContatoDto> atualizarContato(@PathVariable Integer id,
			@RequestBody @Valid ContatoFormAtlz contatoAtlz) {
		Optional<Contato> optional = contatoRepository.findById(id);
		if (optional.isPresent()) {
			Contato contato = contatoAtlz.atualizar(id, contatoRepository, telefoneRepository,  emailRepository, enderecoRepository);
			return ResponseEntity.ok(new ContatoDto(contato));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerContato(@PathVariable Integer id) {

		Optional<Contato> optional = contatoRepository.findById(id);
		if (optional.isPresent()) {
			contatoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}
}
