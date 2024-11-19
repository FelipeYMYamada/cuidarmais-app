package br.com.fmu.cuidarmais_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmu.cuidarmais_app.model.Vaccine;
import br.com.fmu.cuidarmais_app.service.VaccineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Vaccine")
@RestController
@RequestMapping("/v1/vaccine")
@RequiredArgsConstructor
public class VaccineController {

	@Autowired
	private VaccineService service;
	
	@GetMapping
	public List<Vaccine> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Vaccine findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping("/country/{id}")
	public List<Vaccine> findByCountryId(@PathVariable("id") Long id) {
		return service.findByCountry(id);
	}
	
	@PostMapping
	public Vaccine create(@RequestBody Vaccine vaccine) {
		return service.create(vaccine);
	}
	
	@PutMapping
	public Vaccine update(@RequestBody Vaccine vaccine) {
		return service.update(vaccine);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
