package br.com.fmu.cuidarmais_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.CompanyExam;

public interface CompanyExamRepository extends JpaRepository<CompanyExam, Long>{

	@Query(value = "SELECT SUM(c.price) FROM CompanyExam c " +
				   "INNER JOIN CountryExam ce ON ce.medicalExamId = c.medicalExamId " +
				   "WHERE c.companyId.id = :companyId AND ce.countryId.id = :countryId " +
				   "AND (ce.isRequired = true OR (ce.isRequired = false AND :onlyRequired = true))")
	Double getTotalValue(Long companyId, Long countryId, boolean onlyRequired);
}
