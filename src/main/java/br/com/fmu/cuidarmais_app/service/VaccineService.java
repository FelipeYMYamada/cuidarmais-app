package br.com.fmu.cuidarmais_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.exception.VaccineDuplicatedException;
import br.com.fmu.cuidarmais_app.exception.VaccineNotFoundException;
import br.com.fmu.cuidarmais_app.model.Vaccine;
import br.com.fmu.cuidarmais_app.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VaccineService {
	
	private final VaccineRepository repository;
	
	public List<Vaccine> findAll() {
		return repository.findAll();
	}
	
	public List<Vaccine> findByCountry(Long id) {
		return repository.findByCountry(id);
	}
	
	public Vaccine findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new VaccineNotFoundException("Vacina não encontrada com o ID " + id));
	}
	
	public Vaccine create(Vaccine vaccine) {
		if(repository.findByName(vaccine.getName()).isPresent())
			throw new VaccineDuplicatedException("Já existe uma vacina cadastrada com esse nome!");
		
		return repository.save(vaccine);
	}
	
	public Vaccine update(Vaccine vaccine) {
		if(repository.findByName(vaccine.getName()).isPresent())
			throw new VaccineDuplicatedException("Já existe um vacina cadastrada com esse nome!");
		
		return repository.save(vaccine);
	}
	
	public void delete(Long id) {
		if(repository.findById(id).isEmpty())
			throw new VaccineNotFoundException("Vacina não encontrada com o ID " + id); 
			
		repository.deleteById(id);
	}

}