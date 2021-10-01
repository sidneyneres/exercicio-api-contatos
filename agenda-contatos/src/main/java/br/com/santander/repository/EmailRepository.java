package br.com.santander.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santander.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{

}
