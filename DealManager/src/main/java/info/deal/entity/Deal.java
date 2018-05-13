package info.deal.entity;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Andrzej
 *
 */
@Entity
@Table(name="deal")
public class Deal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotNull(message="pole nie może być puste")
	@Column(name="order_number")
	private String orderNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="pole nie może być puste")
	@Column(name="from_date")
	private LocalDate fromDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="pole nie może być puste")
	@Column(name="to_date")
	private LocalDate toDate;
	
	@NotNull(message="pole nie może być puste")
	@Pattern(regexp = "[0-9]+", message = "to nie jest poprawna wartość")
	@Column(name="amount")
	private String amount;
	
	
	@Column(name="amount_period")
	private String amountPeriod;
	
	@Column(name="active")
	private Integer active=1;
	
	@NotNull(message="pole nie może być puste")
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name = "system_id")
	private Systems systems;
	/**
	 * Empty constructor neccessary to correct ORM
	 */
	public Deal() {
		
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
		return "Deal [id=" + id + ", orderNumber=" + orderNumber + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", amount=" + amount + ", amountPeriod=" + amountPeriod + ", active=" + active + ", systems="
				+ systems + "]";
	}


	
}
