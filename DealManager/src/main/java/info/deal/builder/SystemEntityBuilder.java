package info.deal.builder;

import java.util.List;

import info.deal.entity.Deal;

/**
 * 
 * @Created by am on 12 cze 2018
 *
 */
public interface SystemEntityBuilder {

	System build();

	SystemEntityBuilderImpl id(final Long id);
	SystemEntityBuilderImpl descriptionOfSystem(final String descriptionOfSystem);
	SystemEntityBuilderImpl descriptionOfTechnology(final String descriptionOfTechnology);
	SystemEntityBuilderImpl systemName(final String systemName);
	SystemEntityBuilderImpl systemOwner(final String systemOwner);
	SystemEntityBuilderImpl deals(final List<Deal> deals);
}
