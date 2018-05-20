package info.deal.dto;

import java.util.Date;

import info.deal.entity.Deal;
import info.deal.entity.Systems;

public interface DealEntityBuilder {
	Deal build();
	
	DealEntityBuilderImpl id(final Long id);
	DealEntityBuilderImpl orderNumber(final String orderNumber);
	DealEntityBuilderImpl fromDate(final Date fromDate);
	DealEntityBuilderImpl toDate(final Date toDate);
	DealEntityBuilderImpl amount(final String amount);
	DealEntityBuilderImpl amountPeriod(final String amountPeriod);
	DealEntityBuilderImpl systems(final Systems systems);
}
