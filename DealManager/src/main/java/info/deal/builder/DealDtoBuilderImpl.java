package info.deal.builder;

import java.util.Date;

import info.deal.api.v1.controller.model.DealDto;
import info.deal.entity.Systems;

public class DealDtoBuilderImpl implements DealDtoBuilder {

	private DealDto dealDto;

	public DealDtoBuilderImpl() {
		dealDto = new DealDto();
	}

	@Override
	public DealDto build() {
		return dealDto;
	}

	@Override
	public DealDtoBuilderImpl id(Long id) {
		dealDto.setId(id);
		return this;
	}

	@Override
	public DealDtoBuilderImpl orderNumber(String orderNumber) {
		dealDto.setOrderNumber(orderNumber);
		return this;
	}

	@Override
	public DealDtoBuilderImpl fromDate(Date fromDate) {
		dealDto.setFromDate(fromDate);
		return this;
	}

	@Override
	public DealDtoBuilderImpl toDate(Date toDate) {
		dealDto.setToDate(toDate);
		return this;
	}

	@Override
	public DealDtoBuilderImpl amount(String amount) {
		dealDto.setAmount(amount);
		return this;
	}

	@Override
	public DealDtoBuilderImpl amountPeriod(String amountPeriod) {
		dealDto.setAmountPeriod(amountPeriod);
		return this;
	}

	@Override
	public DealDtoBuilderImpl active(Integer active) {
		dealDto.setActive(active);
		return this;
	}

	@Override
	public DealDtoBuilderImpl systems(Systems systems) {
		dealDto.setSystems(systems);
		return this;
	}

}
