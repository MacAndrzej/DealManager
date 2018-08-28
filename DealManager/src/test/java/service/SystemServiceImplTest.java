//package service;
///**
// * 
// */
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import info.deal.api.v1.controller.mapper.SystemMapper;
//import info.deal.api.v1.controller.model.SystemDto;
//import info.deal.builder.SystemEntityBuilderImpl;
//import info.deal.dao.SystemDAO;
//import info.deal.entity.Systems;
//import info.deal.service.SystemService;
//import info.deal.service.SystemServiceImpl;
//
///**
// * @author Andrzej
// *
// */
//// @RunWith(MockitoJUnitRunner.class)
//public class SystemServiceImplTest {
//
//	private final Long ID = 1L;
//
//	@Mock
//	SystemDAO systemDAO;
//
//	SystemService systemService;
//
//	@Before
//	public void setup() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		systemService = new SystemServiceImpl(systemDAO, SystemMapper.INSTANCE);
//	}
//
//	/**
//	 * Test method for {@link info.deal.service.SystemServiceImpl#getSystems()}.
//	 */
//	@Test
//	public void testGetSystems() throws Exception {
//		// given
//		List<Systems> systemList = Arrays.asList(new Systems(), new Systems(), new Systems());
//
//		// when
//		when(systemDAO.getSystems()).thenReturn(systemList);
//
//		List<SystemDto> systemDtos = systemService.getSystems();
//
//		// then
//		assertEquals(systemDtos.size(), 3);
//		verify(systemDAO, times(1)).getSystems();
//	}
//
//	/**
//	 * Test method for {@link info.deal.service.SystemServiceImpl#findById(long)}.
//	 */
//	@Test
//	public void testFindById_EntryFound() {
//		// given
//		Systems first = new SystemEntityBuilderImpl().id(1L).build();
//
//		// when
//		when(systemDAO.findById(1L)).thenReturn(first);
//
//		SystemDto actualDto = systemService.findById(1L);
//
//		// then
//		assertEquals(first.getId(), actualDto.getId());
//		assertEquals(ID, actualDto.getId());
//		verify(systemDAO, times(1)).findById(1L);
//		verify(systemDAO, never()).getSystems();
//	}
//
//	/**
//	 * Test method for
//	 * {@link info.deal.service.SystemServiceImpl#saveSystem(info.deal.entity.Systems)}.
//	 */
//	@Test
//	public void testSaveSystem() {
//		// given
//		Systems first = new SystemEntityBuilderImpl().id(1L).build();
//
//		// when
//		when(systemDAO.saveSystem(first)).thenReturn(first);
//
//		Systems actual = systemDAO.saveSystem(first);
//
//		// then
//		assertEquals(actual, first);
//		verify(systemDAO, times(1)).saveSystem(first);
//	}
//
//}
