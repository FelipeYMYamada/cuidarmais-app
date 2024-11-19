package br.com.fmu.cuidarmais_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CountryVaccine {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@JoinColumn(name = "vaccine_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Vaccine vaccineId;

	@JoinColumn(name = "country_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Country countryId;
	
	@NotNull
	private Boolean isRequired;

}
