package info.deal.builder;

import java.util.Date;

import info.deal.entity.Deal;
import info.deal.entity.Systems;
/**
 * 
 * @Created by am on 12 cze 2018
 *
 */
public interface DealEntityBuilder {
	
	Deal build();
	
	DealEntityBuilderImpl id(final Long id);
	DealEntityBuilderImpl orderNumber(final String orderNumber);
	DealEntityBuilderImpl fromDate(final Date fromDate);
	DealEntityBuilderImpl toDate(final Date toDate);
	DealEntityBuilderImpl amount(final String amount);
	DealEntityBuilderImpl amountPeriod(final String amountPeriod);
	DealEntityBuilderImpl active(final Integer active);
	DealEntityBuilderImpl systems(final Systems systems);
}
