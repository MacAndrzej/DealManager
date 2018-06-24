package info.deal.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.deal.entity.Deal;
import info.deal.entity.Systems;
import info.deal.service.DealServiceImpl;

/**
 * 
 * @author Andrzej Repository layer of the application.
 */
@Repository
public class SystemDAOImpl implements SystemDAO {

	final static Logger logger = Logger.getLogger(SystemDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Returns a list of all systems entries.
	 */
	public List<Systems> getSystems() {
		logger.info("Entering to SystemDAOImpl, into getSystems method");
		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		/* create a query */
		Query<Systems> theQuery = currentSession.createQuery("from Systems", Systems.class);
		/* execute query and get result list */
		List<Systems> systems = theQuery.getResultList();
		/* return the result */
		return systems;
	}

	/**
	 * Finds a system entry.
	 */
	public Systems findById(long theId) {
		logger.info("Entering to SystemDAOImpl, into findById method");
		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		/* get  system entry*/
		Systems system = currentSession.get(Systems.class, theId);
		return system;
	}

	/**
	 * Saves a system entry.
	 * @return 
	 */
	public Systems saveSystem(Systems theSystems) {
		logger.info("Entering to SystemDAOImpl, into saveSystems method");
		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theSystems);
		logger.info("Save System successful" + theSystems.toString());
		return theSystems;
	}

}
