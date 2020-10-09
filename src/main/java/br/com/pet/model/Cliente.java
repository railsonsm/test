package br.com.pet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.pet.model.payload.ClientForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private String telefoneFixo;
	
	private String identificador;
	
	private Boolean ativo;
	
	public Cliente update(ClientForm form) {
		this.nome = form.getNome();
		this.telefone = form.getTelefone();
		this.telefoneFixo = form.getTelefoneFixo();
		return this;
	}

	public Cliente(Long id) {
		this.id = id;
	}
	
	
}
