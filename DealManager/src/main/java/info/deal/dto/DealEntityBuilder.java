package info.deal.dto;

import java.util.Date;

import info.deal.entity.Deal;
import info.deal.entity.Systems;

public class DealEntityBuilder {

	private Deal deal;

	public DealEntityBuilder() {
		deal = new Deal();
	}

	public DealEntityBuilder id(Long id) {
		deal.setId(id);
		return this;
	}

	public DealEntityBuilder orderNumber(String orderNumber) {
		deal.setOrderNumber(orderNumber);
		return this;
	}

	public DealEntityBuilder fromDate(Date fromDate) {
		deal.setFromDate(fromDate);
		return this;
	}

	public DealEntityBuilder toDate(Date toDate) {
		deal.setToDate(toDate);
		return this;
	}

	public DealEntityBuilder amount(String amount) {
		deal.setAmount(amount);
		return this;
	}

	public DealEntityBuilder amountPeriod(String amountPeriod) {
		deal.setAmountPeriod(amountPeriod);
		return this;
	}

	public DealEntityBuilder systems(Systems systems) {
		deal.setSystems(systems);
		;
		return this;
	}

	public Deal build() {
		return deal;
	}

}
