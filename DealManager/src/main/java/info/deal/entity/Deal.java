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
import javax.persistence.Table;


@Entity
@Table(name="deal")
public class Deal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="deal_number")
	private String dealNumber;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="finish_date")
	private LocalDate finishDate;
	
	@Column(name="sum_of_deal")
	private Integer sumOfDeal;
	
	@Enumerated(EnumType.STRING)
	@Column(name="settlement_period")
	private SettlementPeriod settlementPeriod;
	
	@Column(name="active")
	private Integer active;
	
//	@OneToOne
//	@JoinColumn(name = "system_id")
//	private System system;
	
	public Deal() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealNumber() {
		return dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public Integer getSumOfDeal() {
		return sumOfDeal;
	}

	public void setSumOfDeal(Integer sumOfDeal) {
		this.sumOfDeal = sumOfDeal;
	}

	public SettlementPeriod getSettlementPeriod() {
		return settlementPeriod;
	}

	public void setSettlementPeriod(SettlementPeriod settlementPeriod) {
		this.settlementPeriod = settlementPeriod;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

//	public System getSystem() {
//		return system;
//	}
//
//	public void setSystem(System system) {
//		this.system = system;
//	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", dealNumber=" + dealNumber + ", startDate=" + startDate + ", finishDate="
				+ finishDate + ", sumOfDeal=" + sumOfDeal + ", settlementPeriod=" + settlementPeriod + ", active="
				+ active + "]";
	}
	

	
}
