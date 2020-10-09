package br.com.pet.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.pet.exception.AnotherOwnerException;
import br.com.pet.exception.NoContentException;
import br.com.pet.exception.ObjectNotFoundException;
import br.com.pet.model.Cliente;
import br.com.pet.model.Pet;
import br.com.pet.model.payload.PetResponse;
import br.com.pet.repository.PetRespository;
import br.com.pet.util.ApiUtil;

@Service
public class PetService implements IService<Pet> {
	
	private static final Logger log = LoggerFactory.getLogger(PetService.class);
	
	@Autowired
	private PetRespository petRespository;
	

	@Override
	public PetResponse save(Pet cliente) {
		log.info("save new pet", cliente);
			
		Pet saved = petRespository.save(cliente);
		
		return new PetResponse(saved);
	}

	@Override
	public PetResponse update(Long id, Pet cliente) {
		log.info("update, id ={}", id);
				
		Pet updated = petRespository.save(cliente);
		
		return new PetResponse(updated);
	}

	@Override
	public void delete(Long id) {
		log.info("delete, id ={}", id);
		
		Pet cliente= getPetById(id);
			
		petRespository.delete(cliente);
	}

	@Override
	public Page<PetResponse> listAll(Integer page, Integer size) {
		log.info("listAll, page = {}, size = {} ", page, size);
		
		PageRequest pageRequest = ApiUtil.PageRequest(page, size);
		
		Page<Pet> response = petRespository.findAll(pageRequest);
		
		if(response.isEmpty()) {
			throw new NoContentException();
		}
		return response.map(PetResponse::new);
	}
	
	public Pet getPetById(Long id) {
		log.info("getPetById, id ={}", id);
		
		return petRespository.findById(id)
		.orElseThrow(ObjectNotFoundException::new);
	}
		
	public void validateUpateClientePet(Long clienteId, Long id) {
		log.info("validateUpateClientePet, clienteId = {}", clienteId);
		
		Pet pet = getPetById(id);
		
		if(!pet.getCliente().getId().equals(clienteId)) {
			throw new AnotherOwnerException();
		}
	}

}
