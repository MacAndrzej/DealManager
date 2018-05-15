
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
	
	SystemService systemServiceMock=mock(SystemService.class);

	
	@Test
	public void testListSystems() throws Exception {
		SystemController controller=new SystemController(systemServiceMock);
		Systems first = new SystemEntityBuilder().id(1L).build();
		Systems second = new SystemEntityBuilder().id(2L).build();
		
		when(systemServiceMock.getSystems()).thenReturn(Arrays.asList(first, second));
		
		
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/pages/listSystems.jsp")).build();

		mockMvc.perform(get("/system/list"))
		.andExpect(status().isOk())
		.andExpect(view().name("listSystems"))
		.andExpect(forwardedUrl("/WEB-INF/views/pages/listSystems.jsp"))
		.andExpect(model().size(1))
		.andExpect(model().attributeExists("systems"))
		.andDo(print());	
		
		verify(systemServiceMock,times(1)).getSystems();
		
	}
	
	@Test
	public void TestShowFormForUpdateSystem() throws Exception {
		SystemController controller=new SystemController(systemServiceMock);
		Systems updated = new SystemEntityBuilder().id(1L).build();
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/pages/systemForm.jsp")).build();
		
		when(systemServiceMock.findById(1L)).thenReturn(updated);
		
		mockMvc.perform(get("/system/showFormForUpdateSystem?systemId=1"))
		.andExpect(view().name("systemForm"))
		.andExpect(forwardedUrl("/WEB-INF/views/pages/systemForm.jsp"))
		.andExpect(model().size(1))
		.andExpect(model().attributeExists("system"))
		.andExpect(model().attributeHasNoErrors("system"))
//		.andExpect(model().attribute("system", hasProperty("id", is(1L))))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	@Test
	public void TestAddSystem() throws Exception{
		
	}

}
