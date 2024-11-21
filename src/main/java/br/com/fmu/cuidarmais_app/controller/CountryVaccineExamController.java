package br.com.fmu.cuidarmais_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmu.cuidarmais_app.dto.CountryVaccineExamDTO;
import br.com.fmu.cuidarmais_app.service.CountryVaccineExamService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "CountryVaccineExam")
@RestController
@RequestMapping("/v1/country/{countryId}/vaccine-exam")
@RequiredArgsConstructor
public class CountryVaccineExamController {

	@Autowired
	private CountryVaccineExamService service;
	
	@GetMapping
	public CountryVaccineExamDTO findById(@PathVariable("countryId") Long countryId) {
		return service.getVaccinesAndExams(countryId);
	}
	
	@GetMapping("/{onlyRequired}")
	public CountryVaccineExamDTO findVaccinesAndExamsDetails(@PathVariable("countryId") Long countryId, 
															 @PathVariable("onlyRequired") Boolean onlyRequired ) {
		return service.getVaccinesAndExamsDetails(countryId, onlyRequired);
	}
	
	@GetMapping("/{onlyRequired}/{companyId}")
	public Double getTotalPrice(@PathVariable("countryId") Long countryId,
								@PathVariable("companyId") Long companyId,
								@PathVariable("onlyRequired") Boolean onlyRequired) {
		return service.getTotalPrice(countryId, companyId, onlyRequired);
	}
}
