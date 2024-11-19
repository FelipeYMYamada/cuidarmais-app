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

import br.com.fmu.cuidarmais_app.dto.CompanyReqDTO;
import br.com.fmu.cuidarmais_app.model.Company;
import br.com.fmu.cuidarmais_app.service.CompanyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Company")
@RestController
@RequestMapping("/v1/company")
@RequiredArgsConstructor
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@GetMapping
	public List<Company> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Company findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Company create(@Valid @RequestBody CompanyReqDTO request) {
		return service.create(request);
	}
	
	@PutMapping
	public Company update(@RequestBody Company company) {
		return service.update(company);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
