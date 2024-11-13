package br.com.fmu.cuidarmais_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.dto.AuthDTO;
import br.com.fmu.cuidarmais_app.dto.UserResDTO;
import br.com.fmu.cuidarmais_app.exception.UserNotFoundException;
import br.com.fmu.cuidarmais_app.mapper.UserMapper;
import br.com.fmu.cuidarmais_app.model.Users;
import br.com.fmu.cuidarmais_app.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final UsersRepository repository;
	
	@Autowired
	private UserMapper mapper;
	
	public UserResDTO signin(AuthDTO auth) {
		Optional<Users> user = repository.signin(auth.getEmail(), auth.getPassword());
		if(user.isPresent())
			return mapper.toUserRes(user.get());
		
		throw new UserNotFoundException("Login inválido");
	}

}
