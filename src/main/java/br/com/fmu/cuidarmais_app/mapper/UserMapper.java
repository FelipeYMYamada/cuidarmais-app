package br.com.fmu.cuidarmais_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.fmu.cuidarmais_app.dto.UserReqDTO;
import br.com.fmu.cuidarmais_app.dto.UserResDTO;
import br.com.fmu.cuidarmais_app.model.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(source = "roleId", target = "roleId.id")
	Users toUsers(UserReqDTO request);
	
	UserResDTO toUserRes(Users users);
}
