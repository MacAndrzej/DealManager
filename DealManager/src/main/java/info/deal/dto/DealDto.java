package info.deal.dto;

import java.util.Date;

/**
 * 
 * @author Andrzej
 *
 */
public class DealDto {
	private String orderNumber;
	private Date fromDate;
	private Date toDate;
	private String amount;
	private String amountPeriod;
	private Integer active;
	private Long systems;

	public DealDto(String orderNumber, Date fromDate, Date toDate, String amount, String amountPeriod, Integer active,
			Long systems) {
		this.orderNumber = orderNumber;

		this.fromDate = fromDate;

		this.toDate = toDate;
		this.amount = amount;
		this.amountPeriod = amountPeriod;
		this.active = active;
		this.systems = systems;
	}

	public DealDto() {
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmountPeriod() {
		return amountPeriod;
	}

	public void setAmountPeriod(String amountPeriod) {
		this.amountPeriod = amountPeriod;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Long getSystems() {
		return systems;
	}

	public void setSystems(Long systems) {
		this.systems = systems;
	}

	@Override
	public String toString() {
		return "DealDto [orderNumber=" + orderNumber + ", fromDateTemp=" + ", fromDate=" + fromDate + ", toDateTemp="
				+ ", toDate=" + toDate + ", amount=" + amount + ", amountPeriod=" + amountPeriod + ", active=" + active
				+ ", systems=" + systems + "]";
	}

}
