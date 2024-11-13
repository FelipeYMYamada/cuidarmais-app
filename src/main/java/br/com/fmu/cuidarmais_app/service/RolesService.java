package br.com.fmu.cuidarmais_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.exception.RoleNameDuplicatedException;
import br.com.fmu.cuidarmais_app.exception.RoleNotFoundException;
import br.com.fmu.cuidarmais_app.model.Roles;
import br.com.fmu.cuidarmais_app.repository.RolesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolesService {
	
	private final RolesRepository repository;
	
	public List<Roles> findAll() {
		return repository.findAll();
	}
	
	public Roles findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RoleNotFoundException("Perfil não encontrado com o ID " + id));
	}
	
	public List<Roles> filterByName(String name) {
		return repository.filterByName(name);
	}
	
	public Roles create(Roles role) {
		if(repository.findByName(role.getName()).isPresent())
			throw new RoleNameDuplicatedException("Já existe um PERFIL cadastrado com esse nome!");
		
		return repository.save(role);
	}
	
	public Roles update(Roles role) {
		if(repository.findByName(role.getName()).isPresent())
			throw new RoleNameDuplicatedException("Já existe um PERFIL cadastrado com esse nome!");
		
		return repository.save(role);
	}
	
	public void delete(Long id) {
		if(repository.findById(id).isEmpty())
			throw new RoleNotFoundException("Perfil não encontrado com o ID " + id); 
			
		repository.deleteById(id);
	}

}
