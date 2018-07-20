//package api;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.Assert.fail;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import info.deal.api.controller.RestSystemController;
//import info.deal.api.controller.model.SystemDto;
//import info.deal.builder.SystemDtoBuilderImpl;
//import info.deal.service.SystemService;
//
//public class RestSystemControllerTest extends AbstractRestControllerTest {
//
//	@Mock
//	SystemService systemService;
//
//	@InjectMocks
//	RestSystemController restSystemController;
//
//	MockMvc mockMvc;
//
//	@Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(restSystemController).build();
//	}
//
//	@Test
//	public void getListOfSystems() throws Exception {
//		// given
//		SystemDto system1 = new SystemDtoBuilderImpl().id(1L).build();
//		SystemDto system2 = new SystemDtoBuilderImpl().id(2L).build();
//
//		// when
//		when(systemService.getSystems()).thenReturn(Arrays.asList(system1, system2));
//
//		// then
//		mockMvc.perform(get("/api/systems/").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
//				.andExpect(jsonPath("$.system", hasSize(2)));
//
//		verify(systemService, times(1)).getSystems();
//
//	}
//
//	@Test
//	public void testGetSystem() throws Exception {
//		// given
//		SystemDto system1 = new SystemDtoBuilderImpl().id(1L).descriptionOfSystem("potato").build();
//
//		// when
//		when(systemService.findById(1L)).thenReturn(system1);
//
//		// then
//		mockMvc.perform(get("/api/systems/1").contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(jsonPath("$.descriptionOfSystem", is("potato"))).andExpect(status().isOk());
//	}
//
//	@Test
//	public void testAddSystem() throws Exception {
//		// given
//		SystemDto saveSystem = new SystemDtoBuilderImpl().descriptionOfSystem("potato").build();
//		SystemDto returnSystem = new SystemDtoBuilderImpl().descriptionOfSystem("potato")
//				.systemUrl("/api/systems/1").build();
//		System.out.println(saveSystem);
//		System.out.println(systemService.saveSystemDto(saveSystem));
//		System.out.println(returnSystem);
//
//		// when
//		when(systemService.saveSystemDto(saveSystem)).thenReturn(returnSystem);
//
//		// then
//		mockMvc.perform(post("/api/systems/").contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(status().isCreated());
//	}
//
//}
