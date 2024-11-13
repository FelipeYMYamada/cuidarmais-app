package br.com.fmu.cuidarmais_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmu.cuidarmais_app.dto.AuthDTO;
import br.com.fmu.cuidarmais_app.dto.UserResDTO;
import br.com.fmu.cuidarmais_app.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Login")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
	
	@Autowired
	private LoginService service;

	@PostMapping("/signin")
	public UserResDTO signin(@RequestBody AuthDTO auth) {
		return service.signin(auth);
	}
}
