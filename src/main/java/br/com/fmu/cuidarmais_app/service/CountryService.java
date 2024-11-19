package br.com.fmu.cuidarmais_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.exception.CountryDuplicatedException;
import br.com.fmu.cuidarmais_app.exception.CountryNotFoundException;
import br.com.fmu.cuidarmais_app.model.Country;
import br.com.fmu.cuidarmais_app.repository.CountryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {
	
	private final CountryRepository repository;
	
	public List<Country> findAll() {
		return repository.findAll();
	}
	
	public List<Country> searchByName(String name) {
		return repository.searchByName(name);
	}
	
	public Country findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new CountryNotFoundException("País não encontrado com o ID " + id));
	}
	
	public Country create(Country country) {
		if(repository.findByName(country.getName()).isPresent())
			throw new CountryDuplicatedException("Já existe um país cadastrado com esse nome!");
		
		return repository.save(country);
	}
	
	public void delete(Long id) {
		if(repository.findById(id).isEmpty())
			throw new CountryNotFoundException("País não encontrado com o ID " + id);
			
		repository.deleteById(id);
	}

}
