package br.com.fmu.cuidarmais_app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.fmu.cuidarmais_app.model.MedicalExam;
import br.com.fmu.cuidarmais_app.model.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(Include.NON_NULL)
public class CountryVaccineExamDTO {
	
	private Long id;
	private String name;
	private List<Vaccine> required_vaccines;
	private List<Vaccine> recommended_vaccines;
	private List<MedicalExam> required_exams;
	private List<MedicalExam> recommended_exams;
	private Double totalPrice;

}
