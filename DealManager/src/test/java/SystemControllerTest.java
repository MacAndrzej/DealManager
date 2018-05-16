
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import commons.SystemEntityBuilder;
import info.deal.controller.SystemController;
import info.deal.entity.Systems;
import info.deal.service.SystemService;

public class SystemControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private SystemService systemService;
	
	@InjectMocks
	private SystemController systemController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(systemController)
				.build();
}

	@Test
	public void testListSystems() throws Exception {
		
		Systems first = new SystemEntityBuilder().id(1L).build();
		Systems second = new SystemEntityBuilder().id(2L).build();
		List<Systems> expectedSystems=new ArrayList<>();
		expectedSystems=Arrays.asList(first, second);

		when(systemService.getSystems()).thenReturn(expectedSystems);

		mockMvc.perform(get("/system/list")).andExpect(status().isOk())
		.andExpect(view().name("listSystems"))
		.andExpect(status().is(200))
				.andExpect(model().size(1))
				.andExpect(model().attributeExists("systems"))
				.andExpect(model().attribute("systems", expectedSystems))
				.andDo(print());

		verify(systemService, times(1)).getSystems();

	}

	@Test
	public void TestShowFormForUpdateSystem() throws Exception {
		
		Systems updated = new SystemEntityBuilder().id(1L).build();
		
		when(systemService.findById(1L)).thenReturn(updated);

		mockMvc.perform(get("/system/showFormForUpdateSystem?systemId=1")).andExpect(view().name("systemForm"))
				.andExpect(model().size(1))
				.andExpect(model().attributeExists("system"))
				.andExpect(model().attributeHasNoErrors("system"))
				.andExpect(model().attribute("system", updated))
				.andExpect(status().isOk())
				.andExpect(view().name("systemForm"))
				.andDo(print());
	}
	
	

	@Test
	public void TestAddSystem() throws Exception{
		
		mockMvc.perform(post("/system/saveSystem"))
		.andExpect(redirectedUrl("redirect:/system/list"))
		.andExpect(status().isOk()).andDo(print());
		
		
	}

}
