package br.com.fmu.cuidarmais_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.dto.CompanyReqDTO;
import br.com.fmu.cuidarmais_app.exception.CompanyCnpjDuplicatedException;
import br.com.fmu.cuidarmais_app.exception.CompanyNotFoundException;
import br.com.fmu.cuidarmais_app.mapper.CompanyMapper;
import br.com.fmu.cuidarmais_app.model.Company;
import br.com.fmu.cuidarmais_app.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {
	
	private final CompanyRepository repository;
	
	@Autowired
	private CompanyMapper mapper;
	
	public List<Company> findAll() {
		return repository.findAll();
	}
	
	public Company findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada com o ID " + id));
	}
	
	public Company create(CompanyReqDTO request) {
		Company company = mapper.toCompany(request);
		if(repository.findByCnpj(company.getCnpj()).isPresent())
			throw new CompanyCnpjDuplicatedException("Já existe uma empresa cadastrada com esse CNPJ!");
		
		return repository.save(company);
	}
	
	public Company update(Company company) {
		if(repository.findById(company.getId()).isEmpty())
			throw new CompanyNotFoundException("Empresa não encontrada com o ID " + company.getId());
		
		return repository.save(company);
	}
	
	public void delete(Long id) {
		if(repository.findById(id).isEmpty())
			throw new CompanyNotFoundException("Empresa não encontrada com o ID " + id); 
			
		repository.deleteById(id);
	}

}
