package br.com.fmu.cuidarmais_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

	@Query(value = "SELECT c FROM Country c WHERE c.name LIKE CONCAT('%', :name, '%')")
	public List<Country> searchByName(String name);
	
	@Query(value = "SELECT c FROM Country c WHERE UPPER(c.name) = CONCAT(:name)")
	public Optional<Country> findByName(String name);
}
