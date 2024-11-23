package br.com.fmu.cuidarmais_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.dto.AppointmentReqDTO;
import br.com.fmu.cuidarmais_app.exception.AppointmentNotFoundException;
import br.com.fmu.cuidarmais_app.mapper.AppointmentMapper;
import br.com.fmu.cuidarmais_app.model.Appointment;
import br.com.fmu.cuidarmais_app.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	
	private final AppointmentRepository repository;
	
	@Autowired
	private AppointmentMapper mapper;
	
	public List<Appointment> findAll() {
		return repository.findAll();
	}
	
	public Appointment findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Agendamento não encontrado com o ID " + id));
	}
	
	public List<Appointment> findByUserId(Long userId) {
		return repository.findByUser(userId);
	}
	
	public Appointment create(AppointmentReqDTO request) {
		Appointment appointment = mapper.toAppointment(request);
		return repository.save(appointment);
	}

}
