package br.com.fmu.cuidarmais_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	@Query(value = "SELECT c FROM Company c WHERE c.cnpj = :cnpj")
	public Optional<Company> findByCnpj(String cnpj);
}
