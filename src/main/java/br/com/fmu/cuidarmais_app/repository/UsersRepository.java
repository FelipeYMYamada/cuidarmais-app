package br.com.fmu.cuidarmais_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fmu.cuidarmais_app.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password")
	Optional<Users> signin(@Param("email") String email,
				 		   @Param("password") String password);
	
}
