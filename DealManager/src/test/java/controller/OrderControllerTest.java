package controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.deal.controller.OrderController;
import info.deal.dto.DealEntityBuilderImpl;
import info.deal.entity.Deal;
import info.deal.service.DealService;

public class OrderControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private DealService dealService;
	
	@InjectMocks
	private OrderController orderController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@Test
	public void testListDeals() throws Exception {
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
	public void testListActiveDeals() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowFormForAddChild() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowFormForUpdateOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisableOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddDeal() {
		fail("Not yet implemented");
	}

}
