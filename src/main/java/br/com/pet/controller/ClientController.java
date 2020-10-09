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

import br.com.pet.doc.ClienteApi;
import br.com.pet.model.Cliente;
import br.com.pet.model.payload.ClientForm;
import br.com.pet.model.payload.ClienteResponse;
import br.com.pet.service.ClienteService;

@RestController
@RequestMapping("/clients")
public class ClientController implements ClienteApi {
	
	@Autowired
	private ClienteService clientService;

	@Override
	@PostMapping
	public ResponseEntity<ClienteResponse> create(@Valid ClientForm form) {
		
		Cliente cliente = form.toCliente();
		
		ClienteResponse resp = clientService.save(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(resp);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(ClientForm form, Long id) {
		
		Cliente cliente = clientService.getClienteById(id);
		
		cliente.update(form);
		
		ClienteResponse resp = clientService.update(id, cliente);
		
		return ResponseEntity.ok(resp);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(Long id) {
		
		clientService.delete(id);
		
		return ResponseEntity.ok().build();
	}

	@Override
	@GetMapping
	public ResponseEntity<?> list(Integer page, Integer size) {
		
		Page<ClienteResponse> resp = clientService.listAll(page, size);
		
		return ResponseEntity.ok(resp);
	}


}
