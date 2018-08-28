package info.deal.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	final static Logger logger = Logger.getLogger(SystemServiceImpl.class);
	
	@Autowired
	SystemDAO systemDAO;

	public List<Systems> getSystems() {
		logger.info("Entering to SystemServiceImpl, getSystems()");
		return systemDAO.getSystems();
	}

	public Systems findById(Long theId) {
		logger.info("Entering to SystemServiceImpl, findById()");
		return systemDAO.findById(theId);
	}

	public Systems saveSystem(@Valid Systems theSystem) {
		logger.info("Entering to SystemServiceImpl, saveSystem()");
		return systemDAO.saveSystem(theSystem);
	}

}
