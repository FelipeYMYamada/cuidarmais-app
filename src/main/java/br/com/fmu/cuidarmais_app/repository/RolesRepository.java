package br.com.fmu.cuidarmais_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{

	@Query(value = "SELECT r FROM Roles r WHERE UPPER(r.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	List<Roles> filterByName(String name);
	
	@Query(value = "SELECT r FROM Roles r WHERE r.name LIKE :name")
	Optional<Roles> findByName(String name);
}
