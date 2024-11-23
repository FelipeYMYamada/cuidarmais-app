package br.com.fmu.cuidarmais_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmu.cuidarmais_app.dto.AppointmentReqDTO;
import br.com.fmu.cuidarmais_app.model.Appointment;
import br.com.fmu.cuidarmais_app.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Appointment")
@RestController
@RequestMapping("/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@GetMapping
	public List<Appointment> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{userId}")
	public List<Appointment> findByUserId(@PathVariable("userId") Long userId) {
		return service.findByUserId(userId);
	}
	
	@PostMapping
	public Appointment create(@Valid @RequestBody AppointmentReqDTO request) {
		return service.create(request);
	}
}
