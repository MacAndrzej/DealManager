package info.deal.dto;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DealDtoTest {

	DealDto dealDto;

	@Before
	public void setUp() throws Exception {
		dealDto = new DealDto();
	}

	@Test
	public void testConstructor() {
		// given
		Date fromDate = new Date();
		Date toDate = new Date();

		// when
		DealDto constructor = new DealDto("1/2018", fromDate, toDate, "3000", "monthly", 1, 5L);

		// then
		assertEquals(toDate, constructor.getToDate());
	}

	@Test
	public void testSetOrderNumber() {
		// given
		String orderNumber = "1/2018";

		// when
		dealDto.setOrderNumber(orderNumber);

		// then
		assertEquals(orderNumber, dealDto.getOrderNumber());
	}

	@Test
	public void testSetAmount() {
		// given
		String amount = "3000";

		// when
		dealDto.setAmount(amount);

		// then
		assertEquals(amount, dealDto.getAmount());
	}

	@Test
	public void testSetAmountPeriod() {
		// given
		String amountPeriod = "monthly";

		// when
		dealDto.setAmountPeriod(amountPeriod);

		// then
		assertEquals(amountPeriod, dealDto.getAmountPeriod());
	}

	@Test
	public void testSetActive() {
		// given
		Integer active = 1;

		// when
		dealDto.setActive(active);

		// then
		assertEquals(active, dealDto.getActive());
	}

	@Test
	public void testSetFromDate() {
		// given
		Date fromDate = new Date();

		// when
		dealDto.setFromDate(fromDate);

		// then
		assertEquals(fromDate, dealDto.getFromDate());
	}

	@Test
	public void testSetToDate() {
		// given
		Date toDate = new Date();

		// when
		dealDto.setToDate(toDate);

		// then
		assertEquals(toDate, dealDto.getToDate());
	}

	@Test
	public void testSetSystems() {
		// given
		Long system = 5L;

		// when
		dealDto.setSystems(system);

		// then
		assertEquals(system, dealDto.getSystems());
	}

}
