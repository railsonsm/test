package br.com.pet.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pet.doc.PetApi;
import br.com.pet.exception.ObjectNotFoundException;
import br.com.pet.model.Cliente;
import br.com.pet.model.Pet;
import br.com.pet.model.payload.ClienteResponse;
import br.com.pet.model.payload.PetForm;
import br.com.pet.model.payload.PetResponse;
import br.com.pet.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController implements PetApi {
	
	@Autowired
	private PetService petService;

	@Override
	@PostMapping
	public ResponseEntity<PetResponse> create(@Valid PetForm form) {
		
		Pet pet = form.toPet();
		
		PetResponse resp = petService.save(pet);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resp.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(resp);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(PetForm form, Long id) {
		
		Pet pet = petService.getPetById(id);
		
		petService.validateUpateClientePet(form.getClienteId(), id);
		
		pet.update(form);
		
		PetResponse resp = petService.update(id, pet);
		
		return ResponseEntity.ok(resp);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(Long id) {
		
		petService.delete(id);
		
		return ResponseEntity.ok().build();
	}

	@Override
	@GetMapping
	public ResponseEntity<?> list(Integer page, Integer size) {
		
		Page<PetResponse> resp = petService.listAll(page, size);
		
		return ResponseEntity.ok(resp);
	}
	
	


}
