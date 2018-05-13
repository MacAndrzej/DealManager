package info.deal.dto;

import java.time.LocalDate;
import java.util.Date;

/**
 * 
 * @author Andrzej
 *
 */
public class DealDto {
	private String orderNumber;
	private Date fromDateTemp;
	private LocalDate fromDate;
	private Date toDateTemp;
	private LocalDate toDate;
	private String amount;
	private String amountPeriod;
	private Integer active;
	private Long systems;

	

	

	public DealDto(String orderNumber, Date fromDateTemp, LocalDate fromDate, Date toDateTemp, LocalDate toDate,
			String amount, String amountPeriod, Integer active, Long systems) {
		this.orderNumber = orderNumber;
		this.fromDateTemp = fromDateTemp;
		this.fromDate = fromDate;
		this.toDateTemp = toDateTemp;
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

	public Date getFromDateTemp() {
		return fromDateTemp;
	}

	public void setFromDateTemp(Date fromDateTemp) {
		this.fromDateTemp = fromDateTemp;
	}

	public Date getToDateTemp() {
		return toDateTemp;
	}

	public void setToDateTemp(Date toDateTemp) {
		this.toDateTemp = toDateTemp;
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

	
	public Long getSystems() {
		return systems;
	}

	public void setSystems(Long systems) {
		this.systems = systems;
	}

	@Override
	public String toString() {
		return "DealDto [orderNumber=" + orderNumber + ", fromDateTemp=" + fromDateTemp + ", fromDate=" + fromDate
				+ ", toDateTemp=" + toDateTemp + ", toDate=" + toDate + ", amount=" + amount + ", amountPeriod="
				+ amountPeriod + ", active=" + active + ", systems=" + systems + "]";
	}

	

}
