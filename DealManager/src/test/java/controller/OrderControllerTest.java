package controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.deal.controller.OrderController;
import info.deal.dto.DealDto;
import info.deal.dto.DealEntityBuilderImpl;
import info.deal.dto.SystemEntityBuilderImpl;
import info.deal.entity.Deal;
import info.deal.entity.Systems;
import info.deal.exception.IdNotFoundException;
import info.deal.service.DealService;
import info.deal.service.SystemService;

public class OrderControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private DealService dealService;
	
	@Mock
	private SystemService systemService;
	
	@InjectMocks
	private OrderController orderController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@Test
	public void testListDeals_ListIsNotEmpty() throws Exception {
		Deal first = new DealEntityBuilderImpl().id(1L).build();
		Deal second = new DealEntityBuilderImpl().id(2L).build();
		List<Deal> expectedDeal = new ArrayList<>();
		expectedDeal = Arrays.asList(first, second);

		when(dealService.getDeals()).thenReturn(expectedDeal);

		mockMvc.perform(get("/order/list"))
		.andExpect(status().isOk())
		.andExpect(view().name("listAllOrders"))
				.andExpect(status().is(200))
				.andExpect(model().size(1))
				.andExpect(model().attributeExists("deals"))
				.andExpect(model().attribute("deals", expectedDeal))
				.andDo(print());

		verify(dealService, times(1)).getDeals();
	}
	
	@Test
	public void testListDeals_ListIsEmpty() throws Exception {
		
		List<Deal> expectedDeal = new ArrayList<>();

		when(dealService.getDeals()).thenReturn(expectedDeal);

		mockMvc.perform(get("/order/list"))
		.andExpect(status().isOk())
		.andExpect(view().name("listAllOrders"))
				.andExpect(status().is(200))
				.andExpect(model().size(1))
				.andExpect(model().attributeExists("deals"))
				.andExpect(model().attribute("deals", expectedDeal))
				.andDo(print());

		verify(dealService, times(1)).getDeals();
	}

	@Test
	public void testListActiveDeals_ListIsNotNull() throws Exception {
		Deal first = new DealEntityBuilderImpl().id(1L).active(1).build();
		Deal second = new DealEntityBuilderImpl().id(2L).active(1).build();
		List<Deal> expectedDeal = new ArrayList<>();
		expectedDeal = Arrays.asList(first, second);

		when(dealService.getActiveDeals()).thenReturn(expectedDeal);

		mockMvc.perform(get("/order/listActive"))
		.andExpect(status().isOk())
		.andExpect(view().name("listActiveOrders"))
				.andExpect(status().is(200))
				.andExpect(model().size(1))
				.andExpect(model().attributeExists("deals"))
				.andExpect(model().attribute("deals", expectedDeal))
				.andDo(print());

		verify(dealService, times(1)).getActiveDeals();
	}
	
	
	
	@Test
	public void testListActiveDeals_ListIsNull() throws Exception {
		
		List<Deal> expectedDeal = new ArrayList<>();

		when(dealService.getActiveDeals()).thenReturn(expectedDeal);

		mockMvc.perform(get("/order/listActive"))
		.andExpect(status().isOk())
		.andExpect(view().name("listActiveOrders"))
				.andExpect(status().is(200))
				.andExpect(model().size(1))
				.andExpect(model().attributeExists("deals"))
				.andExpect(model().attribute("deals", expectedDeal))
				.andDo(print());

		verify(dealService, times(1)).getActiveDeals();
	}

	@Test
	public void testShowFormForAddDeal() throws Exception {
		
		Systems first=new SystemEntityBuilderImpl().id(1L).build();
		Systems second=new SystemEntityBuilderImpl().id(2L).build();
		List<Systems> expectedSystems = new ArrayList<>();
		expectedSystems=Arrays.asList(first,second);
		
		when(systemService.getSystems()).thenReturn(expectedSystems);
		
		mockMvc.perform(get("/order/showFormForAddOrder"))
		.andExpect(status().isOk())
		.andExpect(model().size(2))
		.andExpect(model().attributeExists("order"))
		.andExpect(model().attributeExists("allSystems"))
		.andExpect(view().name("dealForm"));
		
		verify(systemService, times(1)).getSystems();
	}

	@Test
	public void testShowFormForUpdateOrder() throws Exception {
		Systems first = new SystemEntityBuilderImpl().id(1L).build();
		Systems second = new SystemEntityBuilderImpl().id(2L).build();
		List<Systems> expectedSystems = new ArrayList<>();
		expectedSystems = Arrays.asList(first, second);

		when(systemService.getSystems()).thenReturn(expectedSystems);

		mockMvc.perform(get("/order/showFormForAddOrder")).andExpect(status().isOk()).andExpect(model().size(2))
				.andExpect(model().attributeExists("order")).andExpect(model().attributeExists("allSystems"))
				.andExpect(view().name("dealForm"));

		verify(systemService, times(1)).getSystems();

	}

	@Test
	public void testDisableOrder_WhenEntryExists() throws Exception {
		Deal deactive = new DealEntityBuilderImpl().id(1L).active(0).build();
		
		when(dealService.disableDeal(1L)).thenReturn(deactive);
		
		mockMvc.perform(get("/order/disableOrder?dealId=1"))
		.andExpect(redirectedUrl("/order/listActive"))
		.andDo(print());
		
	}
	
	@Test
	public void testDisableOrder_WhenEntryDoesNotExist() throws Exception,IdNotFoundException {
		
		when(dealService.disableDeal(1L)).thenReturn(null);
		
		mockMvc.perform(get("/order/disableOrder?dealId=1"))
		.andExpect(status().isNotFound())
		.andDo(print());
		
	}

	@Test
	public void testAddDeal() throws Exception {
		
		mockMvc.perform(post("/order/saveOrder")
				.param("orderNumber", "1/2015")
				.param("amount", "3000")
				.param("amountPeriod","MONTH")
				.param("active","1"))
		.andExpect(redirectedUrl("/order/listActive"));
	}

}


















