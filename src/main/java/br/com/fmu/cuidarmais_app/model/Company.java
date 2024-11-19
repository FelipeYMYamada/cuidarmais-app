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
public class Company {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@NotBlank(message = "O campo nome é obrigatório")
	@Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
	@Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
	private String name;

	@NotNull
	@NotBlank(message = "O campo CNPJ é obrigatório")
	@Size(min = 14, message = "CNPJ deve ter no mínimo 4 caracteres")
	@Size(max = 14, message = "CNPJ deve ter no máximo 4 caracteres")
	private String cnpj;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "companyId" )
	@JsonIgnore
	private Collection<CompanyVaccine> companyVaccineCollection;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "companyId" )
	@JsonIgnore
	private Collection<CompanyExam> companyExamCollection;
}