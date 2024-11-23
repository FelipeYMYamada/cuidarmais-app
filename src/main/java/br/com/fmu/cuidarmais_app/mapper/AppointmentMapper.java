package br.com.fmu.cuidarmais_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.fmu.cuidarmais_app.dto.AppointmentReqDTO;
import br.com.fmu.cuidarmais_app.model.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
	
	AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);
	
	@Mapping(source = "countryId", target = "countryId.id")
	@Mapping(source = "userId", target = "userId.id")
	Appointment toAppointment(AppointmentReqDTO request);

}
