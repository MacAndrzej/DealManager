package mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.internal.util.Assert;

import info.deal.api.v1.controller.mapper.DealMapper;
import info.deal.api.v1.controller.model.DealDto;
import info.deal.builder.DealEntityBuilderImpl;
import info.deal.entity.Deal;

public class DealMapperTest {

	DealMapper dealMapper = DealMapper.INSTANCE;

	@Test
	public void dealToDealDtoTest_dealNotNull() {
		// given
		Deal deal = new DealEntityBuilderImpl().id(1L).build();
		// when
		DealDto dealDto = dealMapper.dealToDealDto(deal);

		// then
		assertEquals(deal.getId(), dealDto.getId());
	}
	
	@Test
	public void dealToDealDtoTest_dealNull() {
		// given
		Deal deal = null;
		// when
		DealDto dealDto = dealMapper.dealToDealDto(deal);

		// then
		Assert.isNull(dealDto);
	}

	@Test
	public void dealDtoToDealTest_dealNotNull() {
		// given
		DealDto dealDto = new DealDto();
		dealDto.setId(1L);
		
		// when
		Deal deal = dealMapper.dealDtoToDeal(dealDto);

		// then
		assertEquals(deal.getId(), dealDto.getId());
	}
	
	@Test
	public void dealDtoToDealTest_dealNull() {
		// given
		DealDto dealDto = null;
		
		// when
		Deal deal = dealMapper.dealDtoToDeal(dealDto);

		// then
		Assert.isNull(deal);
	}

}
