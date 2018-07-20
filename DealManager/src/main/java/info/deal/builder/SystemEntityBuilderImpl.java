package info.deal.builder;

import java.util.List;

import info.deal.entity.Deal;
import info.deal.entity.Systems;


public class SystemEntityBuilderImpl {

	private Systems system;

	public SystemEntityBuilderImpl() {
		system = new Systems();
	}
	
	public SystemEntityBuilderImpl id(Long id) {
		system.setId(id);
		return this;
	}
	
	public SystemEntityBuilderImpl descriptionOfSystem(String descriptionOfSystem) {
		system.setDescriptionOfSystem(descriptionOfSystem);
		return this;
	}
	
	public SystemEntityBuilderImpl descriptionOfTechnology(String descriptionOfTechnology) {
		system.setDescriptionOfTechnology(descriptionOfTechnology);
		return this;
	}
	
	public SystemEntityBuilderImpl systemName(String systemName) {
		system.setSystemName(systemName);
		return this;
	}
	
	public SystemEntityBuilderImpl systemOwner(String systemOwner) {
		system.setSystemOwner(systemOwner);
		return this;
	}
	
	public SystemEntityBuilderImpl deals(List<Deal> deals) {
		system.setDeals(deals);
		return this;
	}
	
	public Systems build() {return system;}

}
