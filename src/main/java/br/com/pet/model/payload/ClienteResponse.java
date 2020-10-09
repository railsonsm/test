package br.com.pet.model.payload;

import br.com.pet.model.Cliente;
import lombok.Getter;

@Getter
public class ClienteResponse {
	
	private Long id;
	
	private String nome;
	
	private String telefone;

	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}
	
}
