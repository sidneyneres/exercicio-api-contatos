package br.com.santander.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santander.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer>{

}
