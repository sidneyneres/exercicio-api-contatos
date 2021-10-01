package br.com.santander.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santander.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

	Optional<Contato> findById(Long id);

	void deleteById(Long id);

}
