package br.com.pet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pet.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Page<Cliente> findAllByAtivoIsTrue(Pageable pageable);
}
