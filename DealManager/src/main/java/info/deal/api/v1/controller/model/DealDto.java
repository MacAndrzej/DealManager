package info.deal.api.v1.controller.model;

import java.util.Date;

import info.deal.entity.Systems;

/**
 * 
 * @Created by am on 25 cze 2018
 *
 */
public class DealDto {

	private Long id;
	private String orderNumber;
	private Date fromDate;
	private Date toDate;
	private String amount;
	private String amountPeriod;
	private Integer active;
	private Systems systems;
	
	public DealDto() {
	}

	public DealDto(Long id, String orderNumber, Date fromDate, Date toDate, String amount, String amountPeriod,
			Integer active, Systems systems) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.amount = amount;
		this.amountPeriod = amountPeriod;
		this.active = active;
		this.systems = systems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public Systems getSystems() {
		return systems;
	}

	public void setSystems(Systems systems) {
		this.systems = systems;
	}

	@Override
	public String toString() {
		return "DealDto [id=" + id + ", orderNumber=" + orderNumber + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", amount=" + amount + ", amountPeriod=" + amountPeriod + ", active=" + active + ", systems="
				+ systems + "]";
	}
	
}
