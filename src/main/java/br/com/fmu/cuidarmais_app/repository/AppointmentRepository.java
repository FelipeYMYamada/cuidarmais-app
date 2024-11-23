package br.com.fmu.cuidarmais_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fmu.cuidarmais_app.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query(value = "SELECT a FROM Appointment a WHERE a.userId = :userId")
	public List<Appointment> findByUser(Long userId);
}
