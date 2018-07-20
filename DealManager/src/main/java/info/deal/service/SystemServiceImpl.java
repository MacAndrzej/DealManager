package info.deal.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import info.deal.api.v1.controller.mapper.SystemMapper;
import info.deal.api.v1.controller.model.SystemDto;
import info.deal.dao.SystemDAO;
import info.deal.entity.Systems;

/**
 * 
 * @author Andrzej
 * 
 *         Service layer of the application.
 *
 */
@Service
@Transactional
public class SystemServiceImpl implements SystemService {

	public SystemServiceImpl(SystemDAO systemDAO, SystemMapper systemMapper) {
		this.systemDAO = systemDAO;
		this.systemMapper = systemMapper;
	}

	final static Logger logger = Logger.getLogger(SystemServiceImpl.class);
	
	private final SystemDAO systemDAO;
	private final SystemMapper systemMapper;

	public List<SystemDto> getSystems() {
		logger.info("Entering to SystemServiceImpl, getSystems()");
		return systemDAO.getSystems().stream().map(systemMapper::systemToSystemDto).collect(Collectors.toList());
	}

	public SystemDto findById(Long theId) {
		logger.info("Entering to SystemServiceImpl, findById()");
		return systemMapper.systemToSystemDto(systemDAO.findById(theId));
	}

	public SystemDto saveSystemDto(@Valid SystemDto theSystemDto) {
		logger.info("Entering to SystemServiceImpl, saveSystem()");

		Systems theSystem = systemMapper.systemDtoToSystem(theSystemDto);
		Systems savedSystem = systemDAO.saveSystem(theSystem);
		SystemDto returnDto = systemMapper.systemToSystemDto(savedSystem);
		returnDto.setSystemUrl("/api/systems/" + savedSystem.getId());

		return returnDto;
	}

	public Systems saveSystem(@Valid Systems theSystem) {
		logger.info("Entering to SystemServiceImpl, saveSystem()");

		return systemDAO.saveSystem(theSystem);
	}

}
