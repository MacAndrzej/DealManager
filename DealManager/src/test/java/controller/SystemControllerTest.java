package controller;

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
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.deal.controller.ControllerExceptionHandler;
import info.deal.controller.SystemController;
import info.deal.dto.SystemEntityBuilderImpl;
import info.deal.entity.Systems;
import info.deal.exception.IdNotFoundException;
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
				.setControllerAdvice(new ControllerExceptionHandler()).build();
	}

	@Test
	public void testListOfSystems_ListIsNotEmpty() throws Exception {

		Systems first = new SystemEntityBuilderImpl().id(1L).build();
		Systems second = new SystemEntityBuilderImpl().id(2L).build();
		List<Systems> expectedSystems = new ArrayList<>();
		expectedSystems = Arrays.asList(first, second);

		when(systemService.getSystems()).thenReturn(expectedSystems);

		mockMvc.perform(get("/system/list")).andExpect(status().isOk()).andExpect(view().name("listSystems"))
				.andExpect(status().is(200)).andExpect(model().size(1)).andExpect(model().attributeExists("systems"))
				.andExpect(model().attribute("systems", expectedSystems)).andDo(print());

		verify(systemService, times(1)).getSystems();
	}

	@Test
	public void testListOfSystems_ListIsEmpty() throws Exception {

		List<Systems> expectedSystems = new ArrayList<>();

		when(systemService.getSystems()).thenReturn(expectedSystems);

		mockMvc.perform(get("/system/list")).andExpect(status().isOk()).andExpect(view().name("listSystems"))
				.andExpect(model().size(1)).andExpect(model().attributeExists("systems"))
				.andExpect(model().attribute("systems", expectedSystems)).andDo(print());

		verify(systemService, times(1)).getSystems();
	}

	@Test
	public void TestShowFormForUpdateSystem_EntryExists() throws Exception {

		Systems updated = new SystemEntityBuilderImpl().id(1L).build();

		when(systemService.findById(1L)).thenReturn(updated);

		mockMvc.perform(get("/system/showFormForUpdateSystem?systemId=1")).andExpect(view().name("systemForm"))
				.andExpect(model().size(1)).andExpect(model().attributeExists("system"))
				.andExpect(model().attributeHasNoErrors("system")).andExpect(model().attribute("system", updated))
				.andExpect(status().isOk()).andExpect(view().name("systemForm")).andDo(print());
	}

	@Test
	public void TestShowFormForUpdateSystem_EntryExists_StringInsteadOfLong() throws Exception {

		mockMvc.perform(get("/system/showFormForUpdateSystem?systemId=kk")).andExpect(status().isBadRequest())
				.andExpect(view().name("400"));
	}

	@Test
	public void TestShowFormForUpdateSystem_EntryDoesNotExist() throws Exception, IdNotFoundException {

		when(systemService.findById(1L)).thenReturn(null);

		mockMvc.perform(get("/system/showFormForUpdateSystem?systemId=1")).andExpect(status().isNotFound())
				.andExpect(view().name("404"));
	}

	@Test
	public void TestAddSystem_NoErrorsAfterValidation() throws Exception {
		mockMvc.perform(post("/system/saveSystem").param("descriptionOfSystem", "1L")
				.param("descriptionOfTechnology", "Java").param("systemName", "Tomato").param("systemOwner", "Farmer"))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/system/list"));
	}

	@Test
	public void TestAddSystem_ValidationErrors() throws Exception {
		mockMvc.perform(
				post("/system/saveSystem").param("descriptionOfSystem", "1L").param("descriptionOfTechnology", "Java")
						.param("systemName", "Tomato").param("systemOwner", "Farmer").param("id", "bike"))
				.andExpect(view().name("systemForm"));
	}

}
