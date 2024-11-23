package br.com.fmu.cuidarmais_app.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AppointmentReqDTO {
	
	@NotNull(message = "O campo cliente é obrigatório")
	private Long userId;
	
	@NotNull(message = "O campo laboratório é obrigatório")
	private Long companyId;
	
	@NotNull(message = "O campo apenas obrigatórios é obrigatório")
	private Boolean onlyRequired;
	
	@NotNull(message = "O campo data agendamento é obrigatório")
	private LocalDateTime scheduleDate;

}
