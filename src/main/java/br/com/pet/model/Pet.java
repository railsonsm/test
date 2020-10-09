package br.com.pet.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.pet.model.enums.Tipo;
import br.com.pet.model.payload.PetForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
		
	@ManyToOne
	@JoinColumn(name= "raca_id")
	private Raca raca;
	
	@ManyToOne
	@JoinColumn(name= "cliente_id")
	private Cliente cliente;
	
	public Pet update(PetForm form) {
		this.nome = form.getNome();
		this.cliente = Objects.nonNull(form.getClienteId()) ? new Cliente(form.getClienteId()) : null;
		this.raca = Objects.nonNull(form.getRacaId()) ? new Raca(form.getRacaId()) : null;
		return this;
	}
}

