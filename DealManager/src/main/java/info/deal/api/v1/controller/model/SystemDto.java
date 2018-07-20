package info.deal.api.v1.controller.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.deal.entity.Deal;

public class SystemDto {
	private Long id;
	private String descriptionOfSystem;
	private String descriptionOfTechnology;
	private String systemName;
	private String systemOwner;
	private List<Deal> deals;
	
	public SystemDto() {
	}

	public SystemDto(Long id, String descriptionOfSystem, String descriptionOfTechnology, String systemName,
			String systemOwner, List<Deal> deals) {
		this.id = id;
		this.descriptionOfSystem = descriptionOfSystem;
		this.descriptionOfTechnology = descriptionOfTechnology;
		this.systemName = systemName;
		this.systemOwner = systemOwner;
		this.deals = deals;
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

	
	
	@Override
	public String toString() {
		return "SystemDto [id=" + id + ", descriptionOfSystem=" + descriptionOfSystem + ", descriptionOfTechnology="
				+ descriptionOfTechnology + ", systemName=" + systemName + ", systemOwner=" + systemOwner + ", deals="
				+ deals + ", systemUrl=" + systemUrl + "]";
	}



	@JsonProperty("system_url")
	private String systemUrl;

	public String getSystemUrl() {
		return systemUrl;
	}

	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}
	
}
