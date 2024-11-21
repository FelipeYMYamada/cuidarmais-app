package br.com.fmu.cuidarmais_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.MedicalExam;

public interface MedicalExamRepository extends JpaRepository<MedicalExam, Long>{

	@Query(value = "SELECT m FROM MedicalExam m INNER JOIN CountryExam c ON c.medicalExamId.id = m.id " +
			 	   "WHERE c.countryId.id = :id")
	public List<MedicalExam> findByCountry(Long id);
	
	@Query(value = "SELECT m FROM MedicalExam m INNER JOIN CountryExam c ON c.medicalExamId.id = m.id " +
			"WHERE c.countryId.id = :id AND c.isRequired = :isRequired")
	public List<MedicalExam> findByCountryRequired(Long id, boolean isRequired);
	
}
