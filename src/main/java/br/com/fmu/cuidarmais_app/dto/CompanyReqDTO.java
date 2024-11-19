package br.com.fmu.cuidarmais_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompanyReqDTO {

	@NotNull
	@NotBlank(message = "O campo nome é obrigatório")
	@Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
	@Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
	private String name;

	@NotNull
	@NotBlank(message = "O campo CNPJ é obrigatório")
	@Size(min = 14, message = "CNPJ deve ter no mínimo 4 caracteres")
	@Size(max = 14, message = "CNPJ deve ter no máximo 4 caracteres")
	private String cnpj;
	
}
