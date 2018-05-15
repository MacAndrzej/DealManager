
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
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
import info.deal.dto.SystemDTO;
import info.deal.entity.Systems;
import info.deal.service.SystemService;


public class SystemControllerTest {

	private MockMvc mockMvc;

//	@Mock
//	private SystemService systemServiceMock;

	@Test
	public void testListSystems() throws Exception {
		
		Systems first = new SystemEntityBuilder().id(1L).build();
		Systems second = new SystemEntityBuilder().id(2L).build();
		
		SystemService systemServiceMock=mock(SystemService.class);
		
		when(systemServiceMock.getSystems()).thenReturn(Arrays.asList(first, second));
		
		SystemController controller=new SystemController(systemServiceMock);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/pages/listSystems.jsp")).build();

		mockMvc.perform(get("/system/list"))
		.andExpect(status().isOk())
		.andExpect(view().name("listSystems"))
		.andExpect(forwardedUrl("/WEB-INF/views/pages/listSystems.jsp"))
		.andExpect(model().size(1))
		.andExpect(model().attributeExists("systems"))
		.andDo(print());	
		
		
	}

}
