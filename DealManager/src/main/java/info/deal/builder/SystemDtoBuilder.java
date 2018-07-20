package info.deal.builder;

import java.util.List;

import info.deal.api.v1.controller.model.SystemDto;
import info.deal.entity.Deal;

/**
 * 
 * @Created by am on 12 cze 2018
 *
 */
public interface SystemDtoBuilder {

	SystemDto build();

	SystemDtoBuilderImpl id(final Long id);
	SystemDtoBuilderImpl descriptionOfSystem(final String descriptionOfSystem);
	SystemDtoBuilderImpl descriptionOfTechnology(final String descriptionOfTechnology);
	SystemDtoBuilderImpl systemName(final String systemName);
	SystemDtoBuilderImpl systemOwner(final String systemOwner);
	SystemDtoBuilderImpl deals(final List<Deal> deals);
	SystemDtoBuilderImpl systemUrl(final String systemUrl);
}
