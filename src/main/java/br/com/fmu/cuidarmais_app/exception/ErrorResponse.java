package br.com.fmu.cuidarmais_app.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private List<String> messages = new ArrayList<String>();
	
	public void addMessage(String message) {
		messages.add(message);
	}

}
