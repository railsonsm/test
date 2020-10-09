package br.com.pet.model.payload;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import br.com.pet.model.Cliente;
import lombok.Getter;

@Getter
public class ClientForm {

	@NotNull
	private String nome;
	
	@NotNull
	private String telefone;
	
	private String telefoneFixo;
	
	public Cliente toCliente() {
		return Cliente
				.builder().nome(nome).telefone(telefone)
				.telefoneFixo(telefoneFixo).ativo(Boolean.TRUE)
				.identificador(UUID.randomUUID().toString()).build();
	}
	
}
