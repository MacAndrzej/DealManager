package info.deal.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.deal.dao.SystemDAO;
import info.deal.entity.Systems;
/**
 * 
 * @author Andrzej
 * 
 *  Service layer of the application.
 *
 */
@Service
@Transactional
public class SystemServiceImpl implements SystemService {

	@Autowired
	private SystemDAO systemDAO;

	public List<Systems> getSystems() {
		List<Systems> systems = new ArrayList<Systems>();
		for (Systems s : systemDAO.getSystems()) {
			systems.add(s);
		}

		return systems;
	}

	public Systems findById(long theId) {
		Systems theSystem = systemDAO.findById(theId);
		return theSystem;
	}

	public Systems saveSystem(@Valid Systems theSystems) {
		systemDAO.saveSystem(theSystems);
		return theSystems;

	}

}
