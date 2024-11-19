package br.com.fmu.cuidarmais_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.exception.CompanyVaccineNotFoundException;
import br.com.fmu.cuidarmais_app.model.CompanyVaccine;
import br.com.fmu.cuidarmais_app.repository.CompanyVaccineRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyVaccineService {
	
	private final CompanyVaccineRepository repository;
	
	public List<CompanyVaccine> findAll() {
		return repository.findAll();
	}
	
	public CompanyVaccine findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new CompanyVaccineNotFoundException("company_vaccine não encontrado com o ID " + id));
	}
	
	public List<CompanyVaccine> findByCompany(Long companyId) {
		return repository.findByCompany(companyId);
	}
	
	public List<CompanyVaccine> findByVaccine(Long vaccineId) {
		return repository.findByVaccine(vaccineId);
	}
	
	public CompanyVaccine create(CompanyVaccine companyVaccine) {
		return repository.save(companyVaccine);
	}
	
	public void delete(Long id) {
		if(repository.findById(id).isEmpty())
			throw new CompanyVaccineNotFoundException("company_vaccine não encontrado com o ID " + id); 
			
		repository.deleteById(id);
	}

}
