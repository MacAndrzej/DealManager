package entity;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

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
		// given
		Long idValue = 4L;

		// when
		deal.setId(idValue);

		// then
		assertEquals(idValue, deal.getId());
	}

	@Test
	public void testSetOrderNumber() {
		// given
		String orderNumberValue = "1/2018";

		// when
		deal.setOrderNumber(orderNumberValue);

		// then
		assertEquals(orderNumberValue, deal.getOrderNumber());
	}

	@Test
	public void testSetFromDate() {
		// given
		Date toDateValue = new Date();

		// when
		deal.setToDate(toDateValue);

		// then
		assertEquals(toDateValue, deal.getToDate());
	}

	@Test
	public void testSetToDate() {
		// given
		Date fromDateValue = new Date();

		// when
		deal.setFromDate(fromDateValue);

		// then
		assertEquals(fromDateValue, deal.getFromDate());
	}

	@Test
	public void testSetAmount() {
		// given
		String amountValue = "3000";

		// when
		deal.setAmount(amountValue);

		// then
		assertEquals(amountValue, deal.getAmount());
	}

	@Test
	public void testSetAmountPeriod() {
		// given
		String amountPeriod = "MONTH";

		// when
		deal.setAmountPeriod(amountPeriod);

		// then
		assertEquals(amountPeriod, deal.getAmountPeriod());
	}

	@Test
	public void testSetActive() {
		// given
		Integer activeValue = 1;

		// when
		deal.setActive(activeValue);

		// then
		assertEquals(activeValue, deal.getActive());
	}

	@Test
	public void testSetSystems() {
		// given
		Systems systemsValue = new Systems();

		// when
		deal.setSystems(systemsValue);

		// then
		assertEquals(systemsValue, deal.getSystems());
	}

}
