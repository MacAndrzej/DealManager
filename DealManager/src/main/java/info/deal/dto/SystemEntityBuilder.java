package info.deal.dto;

import java.util.List;

import info.deal.entity.Deal;
import info.deal.entity.Systems;


public class SystemEntityBuilder {

	private Systems system;

	public SystemEntityBuilder() {
		system = new Systems();
	}
	
	public SystemEntityBuilder id(Long id) {
		system.setId(id);
		return this;
	}
	
	public SystemEntityBuilder descriptionOfSystem(String descriptionOfSystem) {
		system.setDescriptionOfSystem(descriptionOfSystem);
		return this;
	}
	
	public SystemEntityBuilder descriptionOfTechnology(String descriptionOfTechnology) {
		system.setDescriptionOfTechnology(descriptionOfTechnology);
		return this;
	}
	
	public SystemEntityBuilder systemName(String systemName) {
		system.setSystemName(systemName);
		return this;
	}
	
	public SystemEntityBuilder systemOwner(String systemOwner) {
		system.setSystemOwner(systemOwner);
		return this;
	}
	
	public SystemEntityBuilder deals(List<Deal> deals) {
		system.setDeals(deals);
		return this;
	}
	
	public Systems build() {return system;}

}
