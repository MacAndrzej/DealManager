package service;
/**
 * 
 */

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.deal.dao.DealDAO;
import info.deal.dao.SystemDAO;
import info.deal.dto.SystemEntityBuilderImpl;
import info.deal.entity.Systems;
import info.deal.service.DealService;
import info.deal.service.SystemService;
import info.deal.service.SystemServiceImpl;

/**
 * @author Andrzej
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SystemServiceImplTest {

	
	private SystemServiceImpl systemService;
	
	@Mock
	private SystemDAO systemDAO;


	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		systemService=new SystemServiceImpl(systemDAO);
	}

	/**
	 * Test method for {@link info.deal.service.SystemServiceImpl#getSystems()}.
	 */
	@Test
	public void testGetSystems() {
//	for
		Systems first = new SystemEntityBuilderImpl().id(1L).build();
		Systems second = new SystemEntityBuilderImpl().id(2L).build();
		List<Systems> expectedSystems = new ArrayList<>();
		expectedSystems = Arrays.asList(first, second);
			
//	when
		when(systemService.getSystems()).thenReturn(expectedSystems);
		
		List<Systems> actual=systemService.getSystems();
		
//		then
		assertEquals(actual.size(),2);
		verify(systemDAO,times(1)).getSystems();
	} 

	/**
	 * Test method for {@link info.deal.service.SystemServiceImpl#findById(long)}.
	 */
	@Test
	public void testFindById() {
//		for
		Systems first = new SystemEntityBuilderImpl().id(1L).build();
		Systems second = new SystemEntityBuilderImpl().id(2L).build();
		List<Systems> expectedSystems = new ArrayList<>();
		expectedSystems = Arrays.asList(first, second);
		
//		when
		when(systemService.findById(1L)).thenReturn(first);
		
		Systems actual=systemService.findById(1L);
		
//		then
		assertEquals(actual, first);
		verify(systemDAO,times(1)).findById(1L);
	}

	/**
	 * Test method for
	 * {@link info.deal.service.SystemServiceImpl#saveSystem(info.deal.entity.Systems)}.
	 */
	@Test
	@Ignore
	public void testSaveSystem() {
//		for
		Systems first = new SystemEntityBuilderImpl().id(1L).build();
//		when
		when(systemService.saveSystem(first)).thenReturn(first);
		
		Systems actual=systemService.saveSystem(first);
		
//		then
		assertEquals(actual, first);
	}

}
