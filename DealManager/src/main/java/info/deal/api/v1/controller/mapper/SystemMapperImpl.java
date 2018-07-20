package info.deal.api.v1.controller.mapper;

import org.springframework.stereotype.Component;

import info.deal.api.v1.controller.model.SystemDto;
import info.deal.entity.Systems;

@Component
public class SystemMapperImpl implements SystemMapper {

	@Override
	public SystemDto systemToSystemDto(Systems system) {
		if (system==null) {
			return null;
		}
		SystemDto systemDto=new SystemDto();
		systemDto.setId(system.getId());
		systemDto.setDescriptionOfSystem(system.getDescriptionOfSystem());
		systemDto.setDescriptionOfTechnology(system.getDescriptionOfTechnology());
		systemDto.setSystemName(system.getSystemName());
		systemDto.setSystemOwner(system.getSystemOwner());
		systemDto.setDeals(system.getDeals());
		return systemDto;
	}

	@Override
	public Systems systemDtoToSystem(SystemDto systemDto) {
		if (systemDto==null) {
			return null;
		}
		Systems system=new Systems();
		system.setId(systemDto.getId());
		system.setDescriptionOfSystem(systemDto.getDescriptionOfSystem());
		system.setDescriptionOfTechnology(systemDto.getDescriptionOfTechnology());
		system.setSystemName(systemDto.getSystemName());
		system.setSystemOwner(systemDto.getSystemOwner());
		system.setDeals(systemDto.getDeals());
		return system;
	}

}
