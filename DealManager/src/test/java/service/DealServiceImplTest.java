package service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import info.deal.dao.DealDAO;
import info.deal.dto.DealEntityBuilderImpl;
import info.deal.dto.SystemEntityBuilderImpl;
import info.deal.entity.Deal;
import info.deal.entity.Systems;
import info.deal.exception.IdNotFoundException;
import info.deal.service.DealServiceImpl;
import info.deal.service.SystemService;

public class DealServiceImplTest {
	
	private DealServiceImpl dealService;
	
	@Mock
	private DealDAO dealDAO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		dealService=new DealServiceImpl(dealDAO);
	}

	@Test
	public void testGetDeals() {
//		for
		Deal first = new DealEntityBuilderImpl().id(1L).build();
		Deal second = new DealEntityBuilderImpl().id(2L).build();
		List<Deal> expectedDeal = new ArrayList<>();
		expectedDeal = Arrays.asList(first, second);
		
//		when
		when(dealService.getDeals()).thenReturn(expectedDeal);
		
		List<Deal> actual=dealService.getDeals();
		
//		then
		assertEquals(expectedDeal, actual);
		assertEquals(actual.size(),2);
		verify(dealDAO,times(1)).getDeals();
		
		
	}

	@Test
	public void testGetActiveDeals() {
//		for
		Deal first = new DealEntityBuilderImpl().id(1L).active(1).build();
		Deal second = new DealEntityBuilderImpl().id(2L).active(1).build();
		List<Deal> expectedDeal = new ArrayList<>();
		expectedDeal = Arrays.asList(first, second);
		
//		when
		when(dealService.getActiveDeals()).thenReturn(expectedDeal);
		
		List<Deal> actual=dealService.getActiveDeals();
		
//		then
		assertEquals(expectedDeal, actual);
		assertEquals(actual.size(),2);
		verify(dealDAO,times(1)).getActiveDeals();
	}

	@Test
	public void testFindById_EntryFound() throws IdNotFoundException {
//		for
		Deal first = new DealEntityBuilderImpl().id(1L).build();
		Deal second = new DealEntityBuilderImpl().id(2L).build();
		List<Deal> expectedSystems = new ArrayList<>();
		expectedSystems = Arrays.asList(first, second);
		
//		when
		when(dealService.findById(1L)).thenReturn(first);
		
		Deal actual=dealService.findById(1L);
		
//		then
		assertEquals(actual, first);
		assertNotNull("Nu recipe returned",actual);
		assertEquals(Deal.class, actual.getClass());
		verify(dealDAO,times(1)).findById(1L);
	}
	

	@Test
	public void testSaveDeal() {
//		for
		Deal deal=new DealEntityBuilderImpl().id(1L).orderNumber("1/2018").build();
		
//		when
//		doReturn(deal).when(dealService).saveDeal(deal);
		when(dealService.saveDeal(deal)).thenReturn(deal);
		
		Deal after=dealService.saveDeal(deal);

//		then
		assertEquals(deal,after);
		assertEquals(Deal.class, after.getClass());
		verify(dealDAO,times(1)).saveDeal(deal);
	}

	@Test
	public void testDisableDeal_EntryExists() {
//		for
		Deal active = new DealEntityBuilderImpl().id(1L).active(1).build();
		Deal deactive = new DealEntityBuilderImpl().id(1L).active(0).build();
//		List<Deal> active = new ArrayList<>();
//		active = Arrays.asList(theDeal);
		
//		when
		when(dealService.disableDeal(1L)).thenReturn(deactive);
		
		Deal actual=dealService.disableDeal(1L);
		
//		then
		assertEquals(actual, deactive);
		verify(dealDAO,times(1)).findById(1L);
	}
	
	@Test
	public void testDisableDeal_EntryDoesNotExist() {
//		for
		
//		when
		when(dealService.disableDeal(1L)).thenReturn(null);
		
		Deal actual=dealService.disableDeal(1L);
		
//		then
		assertEquals(actual, null);
		verify(dealDAO,times(1)).findById(1L);
	}

	@Test
	@Ignore
	public void testImportCsv() {
		fail("Not yet implemented");
	}

}
