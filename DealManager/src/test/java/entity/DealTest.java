package entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import info.deal.dto.SystemEntityBuilderImpl;
import info.deal.entity.Deal;
import info.deal.entity.Systems;

/**
 * 
 * @author Andrzej
 *
 */
public class DealTest {

	Deal deal;

	@Before
	public void setup() {
		deal = new Deal();
	}

	@Test
	public void testSetId() {
		Long idValue = 4L;

		deal.setId(idValue);

		assertEquals(idValue, deal.getId());
	}

	@Test
	public void testSetOrderNumber() {
		String orderNumberValue = "1/2018";

		deal.setOrderNumber(orderNumberValue);

		assertEquals(orderNumberValue, deal.getOrderNumber());
	}

	@Test
	public void testSetFromDate() {
		Date toDateValue = new Date();

		deal.setToDate(toDateValue);

		assertEquals(toDateValue, deal.getToDate());
	}

	@Test
	public void testSetToDate() {
		Date fromDateValue = new Date();

		deal.setFromDate(fromDateValue);

		assertEquals(fromDateValue, deal.getFromDate());
	}

	@Test
	public void testSetAmount() {
		String amountValue = "3000";

		deal.setAmount(amountValue);

		assertEquals(amountValue, deal.getAmount());
	}

	@Test
	public void testSetAmountPeriod() {
		String amountPeriod = "MONTH";

		deal.setAmountPeriod(amountPeriod);

		assertEquals(amountPeriod, deal.getAmountPeriod());
	}

	@Test
	public void testSetActive() {
		Integer activeValue = 1;

		deal.setActive(activeValue);

		assertEquals(activeValue, deal.getActive());
	}

	@Test
	public void testSetSystems() {
		Systems systemsValue = new SystemEntityBuilderImpl().id(1L).build();

		deal.setSystems(systemsValue);

		assertEquals(systemsValue, deal.getSystems());
	}

}
