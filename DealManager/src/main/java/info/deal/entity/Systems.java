package info.deal.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "systems")
public class Systems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "description_of_system")
	private String descriptionOfSystem;

	@Column(name = "description_of_technology")
	private String descriptionOfTechnology;

	@Column(name = "system_name")
	private String systemName;

	@Column(name = "system_owner")
	private String systemOwner;

	@OneToMany(mappedBy = "systems", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH },fetch=FetchType.LAZY,orphanRemoval = true)
	private List<Deal> deals;

	public Systems() {
	}

	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getDescriptionOfSystem() {
		return descriptionOfSystem;
	}

	public void setDescriptionOfSystem(String descriptionOfSystem) {
		this.descriptionOfSystem = descriptionOfSystem;
	}

	public String getDescriptionOfTechnology() {
		return descriptionOfTechnology;
	}

	public void setDescriptionOfTechnology(String descriptionOfTechnology) {
		this.descriptionOfTechnology = descriptionOfTechnology;
	}

	public String getSystemOwner() {
		return systemOwner;
	}

	public void setSystemOwner(String systemOwner) {
		this.systemOwner = systemOwner;
	}

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	public void add(Deal tempDeal) {
		if (deals == null) {
			deals = new ArrayList<Deal>();
		}
		deals.add(tempDeal);
		tempDeal.setSystems(this);
	}

	@Override
	public String toString() {
		return "Systems [id=" + id + ", descriptionOfSystem=" + descriptionOfSystem + ", descriptionOfTechnology="
				+ descriptionOfTechnology + ", systemName=" + systemName + ", systemOwner=" + systemOwner + ", deals="
				+ deals + "]";
	}

}
