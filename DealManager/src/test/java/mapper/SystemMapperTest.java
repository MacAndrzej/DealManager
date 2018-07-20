package mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.internal.util.Assert;

import info.deal.api.v1.controller.mapper.SystemMapper;
import info.deal.api.v1.controller.model.SystemDto;
import info.deal.entity.Systems;

public class SystemMapperTest {

	SystemMapper systemMapper = SystemMapper.INSTANCE;

	@Test
	public void systemToSystemDtoTest_EntryNotNull() {
		// given
		Systems system = new Systems();
		system.setId(1L);
		system.setDescriptionOfTechnology("java");

		// when
		SystemDto systemDto = systemMapper.systemToSystemDto(system);

		// then
		assertEquals(systemDto.getId(), system.getId());
		assertEquals(systemDto.getDescriptionOfTechnology(), system.getDescriptionOfTechnology());
	}

	@Test
	public void systemToSystemDtoTest_EntryIsNull() {
		// given
		Systems system = null;

		// when
		SystemDto systemDto = systemMapper.systemToSystemDto(system);

		// then
		assertEquals(systemDto, system);
		Assert.isNull(systemDto);
	}

	// testy dla nulli

	@Test
	public void systemdtoToSystemTest_EntryNotNull() {
		// given
		SystemDto systemDto = new SystemDto();
		systemDto.setId(1L);
		systemDto.setDescriptionOfSystem("potato");

		// when
		Systems system = systemMapper.systemDtoToSystem(systemDto);

		// then
		assertEquals(systemDto.getId(), system.getId());
		assertEquals(systemDto.getDescriptionOfSystem(), system.getDescriptionOfSystem());
	}
	
	@Test
	public void systemdtoToSystemTest_EntryIsNull() {
		// given
		SystemDto systemDto = null;

		// when
		Systems system = systemMapper.systemDtoToSystem(systemDto);

		// then
		assertEquals(system, systemDto);
		Assert.isNull(system);
	}
	
	

}
