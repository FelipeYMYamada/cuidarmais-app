package br.com.fmu.cuidarmais_app.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@NotBlank(message = "O campo nome é obrigatório")
	private String name;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "roleId" )
	@JsonIgnore
	private Collection<Users> usersCollection;
}
