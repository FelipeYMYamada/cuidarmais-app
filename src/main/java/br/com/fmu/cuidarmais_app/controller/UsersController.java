package br.com.fmu.cuidarmais_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmu.cuidarmais_app.dto.UserReqDTO;
import br.com.fmu.cuidarmais_app.mapper.UserMapper;
import br.com.fmu.cuidarmais_app.model.Users;
import br.com.fmu.cuidarmais_app.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Users")
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UsersController {

	@Autowired
	private UsersService service;
	
	@Autowired
	private UserMapper mapper;
	
	@GetMapping
	public List<Users> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Users findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Users create(@Valid @RequestBody UserReqDTO userReq) {
		Users user = mapper.toUsers(userReq);
		return service.create(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
