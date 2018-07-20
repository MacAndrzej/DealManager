package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.internal.util.Assert;

import info.deal.api.v1.controller.mapper.DealMapper;
import info.deal.api.v1.controller.model.DealDto;
import info.deal.builder.DealEntityBuilderImpl;
import info.deal.dao.DealDAO;
import info.deal.entity.Deal;
import info.deal.exception.IdNotFoundException;
import info.deal.service.DealService;
import info.deal.service.DealServiceImpl;

public class DealServiceImplTest {

	@Mock
	DealDAO dealDAO;

	DealService dealService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		dealService = new DealServiceImpl(DealMapper.INSTANCE, dealDAO);
	}

	@Test
	public void testGetDeals_ListIsNotEmpty() {
		// given
		List<Deal> expectedDeal = Arrays.asList(new Deal(), new Deal(), new Deal());

		// when
		when(dealDAO.getDeals()).thenReturn(expectedDeal);

		List<DealDto> actual = dealService.getDeals();

		// then
		assertEquals(actual.size(), 3);
		verify(dealDAO, times(1)).getDeals();
	}

	@Test
	public void testGetDeals_ListIsEmpty() {
		// given
		List<Deal> expectedDeal = new ArrayList<>();

		// when
		when(dealDAO.getDeals()).thenReturn(expectedDeal);

		List<DealDto> actual = dealService.getDeals();

		// then
		assertEquals(expectedDeal, actual);
//		assertEquals(DealDto.class, actual.getClass());
		verify(dealDAO, times(1)).getDeals();
	}

	@Test
	public void testGetActiveDeals() {
		// given
		Deal first = new DealEntityBuilderImpl().id(1L).active(1).build();
		Deal second = new DealEntityBuilderImpl().id(2L).active(1).build();
		List<Deal> expectedDeal = Arrays.asList(first, second);

		// when
		when(dealDAO.getActiveDeals()).thenReturn(expectedDeal);

		List<DealDto> actual = dealService.getActiveDeals();

		// then
		assertEquals(actual.size(), 2);
		verify(dealDAO, times(1)).getActiveDeals();
	}

	@Test
	public void testFindById() throws IdNotFoundException {
		// given
		Deal first = new DealEntityBuilderImpl().id(1L).build();

		// when
		when(dealDAO.findById(1L)).thenReturn(first);

		DealDto actual = dealService.findById(1L);

		// then
		assertNotNull("Deal returned: ", actual);
		assertEquals(DealDto.class, actual.getClass());
		verify(dealDAO, times(1)).findById(1L);
	}
	
	@Test
	public void testFindById_EntryNotFound() throws IdNotFoundException {
		// given
		
		// when
		when(dealDAO.findById(1L)).thenReturn(null);

		DealDto actual = dealService.findById(1L);

		// then
		Assert.isNull(actual);
		verify(dealDAO, times(1)).findById(1L);
	}

	@Test
	public void testSaveDeal() {
		// given
		Deal deal = new DealEntityBuilderImpl().id(1L).orderNumber("1/2018").build();

		// when
		when(dealDAO.saveDeal(deal)).thenReturn(deal);

		Deal after = dealService.saveDeal(deal);

		// then
		assertEquals(deal, after);
		assertEquals(Deal.class, after.getClass());
		verify(dealDAO, times(1)).saveDeal(deal);
	}

	@Test
	public void testDisableDeal() {
		// given
		Deal active = new DealEntityBuilderImpl().id(1L).active(1).build();
		Deal deactive = new DealEntityBuilderImpl().id(1L).active(0).build();
		// List<Deal> active = new ArrayList<>();
		// active = Arrays.asList(theDeal);

		// when
		when(dealDAO.findById(1L)).thenReturn(deactive);

		Deal actual = dealService.disableDeal(1L);

		// then
		assertEquals(actual, deactive);
		verify(dealDAO, times(1)).findById(1L);
	}

	@Test
	@Ignore
	public void testDisableDeal_EntryDoesNotExist() {
		// given

		// when
		when(dealService.disableDeal(1L)).thenReturn(null);

		Deal actual = dealService.disableDeal(1L);

		// then
		assertEquals(actual, null);
		verify(dealDAO, times(1)).findById(1L);
	}

}
