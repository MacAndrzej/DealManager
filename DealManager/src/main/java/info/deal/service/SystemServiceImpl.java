package info.deal.service;

import java.util.ArrayList;
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
	private SystemDAO systemDAO;

	public List<Systems> getSystems() {
		logger.info("Entering to SystemServiceImpl, getSystems()");
		List<Systems> systems = new ArrayList<Systems>();
		for (Systems s : systemDAO.getSystems()) {
			systems.add(s);
		}

		return systems;
	}

	public Systems findById(long theId) {
		logger.info("Entering to SystemServiceImpl, findById()");
		Systems theSystem = systemDAO.findById(theId);
		return theSystem;
	}

	public Systems saveSystem(@Valid Systems theSystems) {
		logger.info("Entering to SystemServiceImpl, saveSystem()");
		systemDAO.saveSystem(theSystems);
		return theSystems;

	}

}
