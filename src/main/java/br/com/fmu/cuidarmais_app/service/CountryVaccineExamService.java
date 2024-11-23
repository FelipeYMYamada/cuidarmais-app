package br.com.fmu.cuidarmais_app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fmu.cuidarmais_app.dto.CountryVaccineExamDTO;
import br.com.fmu.cuidarmais_app.exception.CountryNotFoundException;
import br.com.fmu.cuidarmais_app.model.Country;
import br.com.fmu.cuidarmais_app.repository.CompanyExamRepository;
import br.com.fmu.cuidarmais_app.repository.CompanyRepository;
import br.com.fmu.cuidarmais_app.repository.CompanyVaccineRepository;
import br.com.fmu.cuidarmais_app.repository.CountryRepository;
import br.com.fmu.cuidarmais_app.repository.MedicalExamRepository;
import br.com.fmu.cuidarmais_app.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryVaccineExamService {
	
	private final CountryRepository countryRepository;
	private final VaccineRepository vaccineRepository;
	private final MedicalExamRepository examRepository;
	private final CompanyVaccineRepository companyVaccineRepository;
	private final CompanyExamRepository companyExamRepository;
	private final CompanyRepository companyRepository;
	
	public CountryVaccineExamDTO getVaccinesAndExams(Long countryId) {
		Optional<Country> country = countryRepository.findById(countryId);
		
		if(!country.isPresent())
			throw new CountryNotFoundException("Nenhum país encontrado com o ID " + countryId);
		
		CountryVaccineExamDTO dto = new CountryVaccineExamDTO();
		dto.setId(country.get().getId());
		dto.setName(country.get().getName());
		dto.setRequired_vaccines(vaccineRepository.findByCountryRequired(countryId, true));
		dto.setRecommended_vaccines(vaccineRepository.findByCountryRequired(countryId, false));
		dto.setRequired_exams(examRepository.findByCountryRequired(countryId, true));
		dto.setRecommended_exams(examRepository.findByCountryRequired(countryId, false));
		dto.setList_company(companyRepository.findAll());
		
		return dto;
	}
	
	public CountryVaccineExamDTO getVaccinesAndExamsDetails(Long countryId, boolean onlyRequired) {
		Optional<Country> country = countryRepository.findById(countryId);
		
		if(!country.isPresent())
			throw new CountryNotFoundException("Nenhum país encontrado com o ID " + countryId);
		
		CountryVaccineExamDTO dto = new CountryVaccineExamDTO();
		dto.setId(country.get().getId());
		dto.setName(country.get().getName());
		dto.setList_company(companyRepository.findAll());
		dto.setRequired_vaccines(vaccineRepository.findByCountryRequired(countryId, true));
		dto.setRequired_exams(examRepository.findByCountryRequired(countryId, true));
		
		if(onlyRequired) {
			dto.setRecommended_vaccines(vaccineRepository.findByCountryRequired(countryId, false));
			dto.setRecommended_exams(examRepository.findByCountryRequired(countryId, false));
		}
		
		return dto;
	}
	
	public Double getTotalPrice(Long countryId, Long companyId, boolean onlyRequired) {
		Double vaccineValue = companyVaccineRepository.getTotalValue(companyId, countryId, onlyRequired);
		Double examValue = companyExamRepository.getTotalValue(companyId, countryId, onlyRequired);
		return vaccineValue + examValue;
	}
	
}
