package info.deal.builder;

import java.util.Date;

import info.deal.entity.Deal;
import info.deal.entity.Systems;

public class DealEntityBuilderImpl implements DealEntityBuilder {

	private Deal deal;

	public DealEntityBuilderImpl() {
		deal = new Deal();
	}

	public DealEntityBuilderImpl id(Long id) {
		deal.setId(id);
		return this;
	}

	public DealEntityBuilderImpl orderNumber(String orderNumber) {
		deal.setOrderNumber(orderNumber);
		return this;
	}

	public DealEntityBuilderImpl fromDate(Date fromDate) {
		deal.setFromDate(fromDate);
		return this;
	}

	public DealEntityBuilderImpl toDate(Date toDate) {
		deal.setToDate(toDate);
		return this;
	}

	public DealEntityBuilderImpl amount(String amount) {
		deal.setAmount(amount);
		return this;
	}

	public DealEntityBuilderImpl amountPeriod(String amountPeriod) {
		deal.setAmountPeriod(amountPeriod);
		return this;
	}

	public DealEntityBuilderImpl systems(Systems systems) {
		deal.setSystems(systems);
		return this;
	}

	public DealEntityBuilderImpl active(Integer active) {
		deal.setActive(active);
		return this;
	}

	public Deal build() {
		return deal;
	}

}
