package br.com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pet.model.Pet;

public interface PetRespository extends JpaRepository<Pet, Long> {
	
	@Query("select case when count(p.id) > 0 then false else false end from Pet p "
			+ "join p.cliente c where c.id = :clienteId")
	Boolean existAnotherOwner(Long clienteId);
}
