package br.com.pet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.pet.exception.NoContentException;
import br.com.pet.exception.ObjectNotFoundException;
import br.com.pet.model.Cliente;
import br.com.pet.model.payload.ClienteResponse;
import br.com.pet.repository.ClienteRepository;
import br.com.pet.util.ApiUtil;

@Service
public class ClienteService implements IService<Cliente> {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ClienteResponse save(Cliente cliente) {
		log.info("save new cliente", cliente);
				
		Cliente saved = clienteRepository.save(cliente);
		
		return new ClienteResponse(saved);
	}

	@Override
	public ClienteResponse update(Long id, Cliente cliente) {
		log.info("update, id ={}", id);
				
		Cliente updated = clienteRepository.save(cliente);
		
		return new ClienteResponse(updated);
	}

	@Override
	public void delete(Long id) {
		log.info("delete, id ={}", id);
		
		Cliente cliente= getClienteById(id);
		
		cliente.setAtivo(Boolean.FALSE);
		
		clienteRepository.save(cliente);
	}

	@Override
	public Page<ClienteResponse> listAll(Integer page, Integer size) {
		log.info("listAll, page = {}, size = {} ", page, size);
		
		PageRequest pageRequest = ApiUtil.PageRequest(page, size);
		
		Page<Cliente> response = clienteRepository.findAllByAtivoIsTrue(pageRequest);
		
		if(response.isEmpty()) {
			throw new NoContentException();
		}
		return response.map(ClienteResponse::new);
	}

	public Cliente getClienteById(Long id) {
		log.info("getClienteById, id ={}", id);
		
		return clienteRepository.findById(id)
		.orElseThrow(ObjectNotFoundException::new);
	}

}
