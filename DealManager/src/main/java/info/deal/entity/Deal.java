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


@Entity
@Table(name="deal")
public class Deal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="order_number")
	private String orderNumber;
	
	@Column(name="from_date")
	private LocalDate fromDate;
	
	@Column(name="to_date")
	private LocalDate toDate;
	
	@Column(name="amount")
	private Integer amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="amount_period")
	private AmountPeriod amountPeriod;
	
	@Column(name="active")
	private Integer active;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name = "system_id")
	private Systems systems;
	
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


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
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


	public Systems getSystems() {
		return systems;
	}


	public void setSystems(Systems systems) {
		this.systems = systems;
	}


	@Override
	public String toString() {
		return "Deal [id=" + id + ", orderNumber=" + orderNumber + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", amount=" + amount + ", amountPeriod=" + amountPeriod + ", active=" + active + "]";
	}
	
}
