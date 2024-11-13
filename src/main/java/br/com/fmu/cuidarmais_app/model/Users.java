package br.com.fmu.cuidarmais_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@NotBlank(message = "O campo nome é obrigatório")
	@Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
	@Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
	private String name;

	@NotNull
	@NotBlank(message = "O campo e-mail é obrigatório")
	@Size(min = 10, message = "E-mail deve ter no mínimo 10 caracteres")
	@Size(max = 120, message = "E-mail deve ter no máximo 120 caracteres")
	private String email;
	
	@NotNull
	@NotBlank(message = "O campo telefone é obrigatório")
	@Size(min = 8, message = "Telefone deve ter no mínimo 8 caracteres")
	@Size(max = 13, message = "Telefone deve ter no máximo 13 caracteres")
	private String phoneNumber;
	
	@NotNull
	@NotBlank(message = "O campo CPF é obrigatório")
	@Size(min = 11, message = "CPF deve ter no mínimo 11 caracteres")
	@Size(max = 11, message = "CPF deve ter no máximo 11 caracteres")
	private String cpf;
	
	@NotNull
	@NotBlank(message = "O campo RG é obrigatório")
	@Size(min = 9, message = "RG deve ter no mínimo 9 caracteres")
	@Size(max = 9, message = "RG deve ter no máximo 9 caracteres")
	private String rg;
	
	@NotNull
	@NotBlank(message = "O campo endereço é obrigatório")
	@Size(min = 5, message = "Endereço deve ter no mínimo 5 caracteres")
	@Size(max = 255, message = "Endereço deve ter no máximo 255 caracteres")
	private String address;

	@NotNull
	@NotBlank(message = "O campo senha é obrigatório")
	@Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
	@Size(max = 255, message = "Senha deve ter no máximo 255 caracteres")
	private String password;

	@JoinColumn(name = "role_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Roles roleId;

}
