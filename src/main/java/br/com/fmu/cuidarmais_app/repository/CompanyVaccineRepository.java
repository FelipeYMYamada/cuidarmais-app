package br.com.fmu.cuidarmais_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.CompanyVaccine;

public interface CompanyVaccineRepository extends JpaRepository<CompanyVaccine, Long>{

	@Query(value = "SELECT c FROM CompanyVaccine c WHERE c.companyId.id = :companyId")
	List<CompanyVaccine> findByCompany(Long companyId);
	
	@Query(value = "SELECT c FROM CompanyVaccine c WHERE c.vaccineId.id = :vaccineId")
	List<CompanyVaccine> findByVaccine(Long vaccineId);
	
	@Query(value = "SELECT SUM(c.price) FROM CompanyVaccine c " +
				   "INNER JOIN CountryVaccine cv ON cv.vaccineId = c.vaccineId " +
				   "WHERE c.companyId.id = :companyId AND cv.countryId.id = :countryId " +
				   "AND (cv.isRequired = true OR (cv.isRequired = false AND :onlyRequired = true))")
	Double getTotalValue(Long companyId, Long countryId, boolean onlyRequired);
}
