package info.deal.dto;

import java.util.List;

import info.deal.entity.Deal;

public class SystemDTO {
	
	
	private Long id;
	private String descriptionOfSystem;
	private String descriptionOfTechnology;
	private String systemName;
	private String systemOwner;
	private List<Deal> deals;
	
	public SystemDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
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
	
	
	
	
}
