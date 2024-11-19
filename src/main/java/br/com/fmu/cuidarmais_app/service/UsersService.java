package br.com.fmu.cuidarmais_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.dto.UserReqDTO;
import br.com.fmu.cuidarmais_app.mapper.UserMapper;
import br.com.fmu.cuidarmais_app.model.Users;
import br.com.fmu.cuidarmais_app.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersRepository repository;
	
	@Autowired
	private UserMapper mapper;
	
	public List<Users> findAll() {
		return repository.findAll();
	}
	
	public Users findById(Long id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	public Users create(UserReqDTO request) {
		Users user = mapper.toUsers(request);
		return repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
