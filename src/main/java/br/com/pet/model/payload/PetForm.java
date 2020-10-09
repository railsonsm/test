package br.com.pet.model.payload;

import javax.validation.constraints.NotNull;

import br.com.pet.model.Cliente;
import br.com.pet.model.Pet;
import br.com.pet.model.Raca;
import lombok.Getter;

@Getter
public class PetForm {

	@NotNull
	private String nome;
	
	@NotNull
	private Long clienteId;
	
	private Long racaId;
	
	public Pet toPet() {
		return Pet.builder().cliente(new Cliente(clienteId))
				.raca(new Raca(racaId)).build();
	}
	
}
