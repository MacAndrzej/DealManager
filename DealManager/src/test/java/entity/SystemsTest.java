package entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import info.deal.builder.DealEntityBuilderImpl;
import info.deal.entity.Deal;
import info.deal.entity.Systems;

/**
 * 
 * @author Andrzej
 *
 */
public class SystemsTest {

	Systems system;

	@Before
	public void setup() {
		system = new Systems();
	}

	@Test
	public void testSetId() {
		Long idValue = 1L;

		system.setId(idValue);

		assertEquals(idValue, system.getId());
	}

	@Test
	public void testSetSystemName() {
		String systemNameValue = "PotatO";

		system.setSystemName(systemNameValue);

		assertEquals(systemNameValue, system.getSystemName());
	}

	@Test
	public void testSetDescriptionOfSystem() {
		String descriptionOfSystemValue = "interesting";

		system.setDescriptionOfSystem(descriptionOfSystemValue);

		assertEquals(descriptionOfSystemValue, system.getDescriptionOfSystem());
	}

	@Test
	public void testSetDescriptionOfTechnology() {
		String DescriptionOfTechnologyValue = "agile";

		system.setDescriptionOfTechnology(DescriptionOfTechnologyValue);

		assertEquals(DescriptionOfTechnologyValue, system.getDescriptionOfTechnology());
	}

	@Test
	public void testSetSystemOwner() {
		String systemOwnerValue = "TomatoMan";

		system.setSystemOwner(systemOwnerValue);

		assertEquals(systemOwnerValue, system.getSystemOwner());
	}

	@Test
	public void testSetDeals() {
		Deal first = new DealEntityBuilderImpl().id(1L).build();
		Deal second = new DealEntityBuilderImpl().id(2L).build();
		List<Deal> dealValue = new ArrayList<>();
		dealValue = Arrays.asList(first, second);

		system.setDeals(dealValue);

		assertEquals(dealValue, system.getDeals());
	}

	@Test
	public void testAdd() {
		List<Deal> dealValue = null;

		system.setDeals(dealValue);

		assertEquals(dealValue, system.getDeals());
	}

}
