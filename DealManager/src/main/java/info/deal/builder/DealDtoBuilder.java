package info.deal.builder;

import java.util.Date;

import info.deal.api.v1.controller.model.DealDto;
import info.deal.entity.Systems;

public interface DealDtoBuilder {
	
	DealDto build();

	DealDtoBuilderImpl id(final Long id);

	DealDtoBuilderImpl orderNumber(final String orderNumber);

	DealDtoBuilderImpl fromDate(final Date fromDate);

	DealDtoBuilderImpl toDate(final Date toDate);

	DealDtoBuilderImpl amount(final String amount);

	DealDtoBuilderImpl amountPeriod(final String amountPeriod);

	DealDtoBuilderImpl active(final Integer active);

	DealDtoBuilderImpl systems(final Systems systems);
}
