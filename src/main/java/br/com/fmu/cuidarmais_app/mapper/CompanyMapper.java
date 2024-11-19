package br.com.fmu.cuidarmais_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.fmu.cuidarmais_app.dto.CompanyReqDTO;
import br.com.fmu.cuidarmais_app.model.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	Company toCompany(CompanyReqDTO request);

}
