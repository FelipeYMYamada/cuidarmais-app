package br.com.fmu.cuidarmais_app.dto;

import br.com.fmu.cuidarmais_app.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserResDTO {
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String cpf;
	private String rg;
	private String address;
	private Roles roleId;
}
