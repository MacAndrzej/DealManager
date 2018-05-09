package info.deal.dto;

import java.time.LocalDate;

import info.deal.entity.AmountPeriod;

/**
 * 
 * @author Andrzej
 *
 */
public class DealDto {
	private String orderNumber;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String amount;
	private AmountPeriod amountPeriod;
	private Integer active;

	public DealDto(String orderNumber, LocalDate fromDate, LocalDate toDate, String amount, AmountPeriod amountPeriod,
			Integer active) {
		this.orderNumber = orderNumber;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.amount = amount;
		this.amountPeriod = amountPeriod;
		this.active = active;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public AmountPeriod getAmountPeriod() {
		return amountPeriod;
	}

	public void setAmountPeriod(AmountPeriod amountPeriod) {
		this.amountPeriod = amountPeriod;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
