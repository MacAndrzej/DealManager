package info.deal.builder;

import java.util.List;

import info.deal.api.v1.controller.model.SystemDto;
import info.deal.entity.Deal;

public class SystemDtoBuilderImpl implements SystemDtoBuilder {

	private SystemDto system;

	public SystemDtoBuilderImpl() {
		system = new SystemDto();
	}

	public SystemDtoBuilderImpl id(Long id) {
		system.setId(id);
		return this;
	}

	public SystemDtoBuilderImpl descriptionOfSystem(String descriptionOfSystem) {
		system.setDescriptionOfSystem(descriptionOfSystem);
		return this;
	}

	public SystemDtoBuilderImpl descriptionOfTechnology(String descriptionOfTechnology) {
		system.setDescriptionOfTechnology(descriptionOfTechnology);
		return this;
	}

	public SystemDtoBuilderImpl systemName(String systemName) {
		system.setSystemName(systemName);
		return this;
	}

	public SystemDtoBuilderImpl systemOwner(String systemOwner) {
		system.setSystemOwner(systemOwner);
		return this;
	}

	public SystemDtoBuilderImpl deals(List<Deal> deals) {
		system.setDeals(deals);
		return this;
	}

	public SystemDtoBuilderImpl systemUrl(String systemUrl) {
		system.setSystemUrl(systemUrl);
		return this;
	}

	public SystemDto build() {
		return system;
	}

}
