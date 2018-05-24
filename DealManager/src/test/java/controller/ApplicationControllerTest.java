package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.deal.controller.ApplicationController;
import info.deal.service.DealService;
import info.deal.service.SystemService;

public class ApplicationControllerTest {
	
	private MockMvc mockMvc;

	@Mock
	private DealService dealService;
	
	@Mock
	private SystemService systemService;
	
	@InjectMocks
	private ApplicationController applicationController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(applicationController).build();
	}
	
	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(view().name("about"))
				.andExpect(status().isOk());
	}

}
