package br.com.fmu.cuidarmais_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long>{

	@Query(value = "SELECT v FROM Vaccine v INNER JOIN CountryVaccine c ON c.vaccineId.id = v.id " +
			 	   "WHERE c.countryId.id = :id")
	public List<Vaccine> findByCountry(Long id);
	
	@Query(value = "SELECT v FROM Vaccine v INNER JOIN CountryVaccine c ON c.vaccineId.id = v.id " +
			"WHERE c.countryId.id = :id AND c.isRequired = :required")
	public List<Vaccine> findByCountryRequired(Long id, boolean required);
	
}
