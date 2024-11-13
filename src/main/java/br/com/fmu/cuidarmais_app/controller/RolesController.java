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

import br.com.fmu.cuidarmais_app.model.Roles;
import br.com.fmu.cuidarmais_app.service.RolesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Roles")
@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RolesController {

	@Autowired
	private RolesService service;
	
	@GetMapping
	public List<Roles> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Roles findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Roles create(@RequestBody Roles roles) {
		return service.create(roles);
	}
	
	@PutMapping
	public Roles update(@RequestBody Roles roles) {
		return service.update(roles);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
