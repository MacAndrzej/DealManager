package info.deal.api.v1.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import info.deal.api.v1.controller.model.SystemDto;
import info.deal.entity.Systems;

/**
 * 
 * @Created by am on 25 cze 2018
 *
 */
@Mapper
public interface SystemMapper {

	SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);

//	@Mapping(source="id",target="id")
	SystemDto systemToSystemDto(Systems system);

//	@Mapping(source="id",target="id")
	Systems systemDtoToSystem(SystemDto systemDto);
}
