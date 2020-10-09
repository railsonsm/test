package br.com.pet.model.payload;

import java.util.Objects;

import br.com.pet.model.Pet;
import lombok.Getter;

@Getter
public class PetResponse {

	private Long id;

	private String raca;

	private ClienteResponse cliente;

	public PetResponse(Pet pet) {
		this.id = pet.getId();
		this.cliente = new ClienteResponse(pet.getCliente());
		if (Objects.nonNull(pet.getRaca())) {
			this.raca = pet.getRaca().getNome();
		}

	}

}
