package br.com.fmu.cuidarmais_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmu.cuidarmais_app.model.Country;
import br.com.fmu.cuidarmais_app.service.CountryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Country")
@RestController
@RequestMapping("/v1/country")
@RequiredArgsConstructor
public class CountryController {

	@Autowired
	private CountryService service;
	
	@GetMapping
	public List<Country> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/search")
	public List<Country> search(@RequestParam String name) {
		return service.searchByName(name);
	}
	
	@GetMapping("/{id}")
	public Country findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Country create(@RequestBody Country country) {
		return service.create(country);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
