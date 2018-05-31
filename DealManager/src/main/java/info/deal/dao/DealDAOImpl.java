package info.deal.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.deal.entity.Deal;

/**
 * 
 * @author Andrzej Repository layer of the application.
 */
@Repository
public class DealDAOImpl implements DealDAO {

	final static Logger logger = Logger.getLogger(DealDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Returns a list of all deals entries.
	 */
	public List<Deal> getDeals() {
		logger.info("Entering to DealDAOImpl");
		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		/* create a query */
		Query<Deal> theQuery = currentSession.createQuery("from Deal", Deal.class);
		/* execute query and get result list */
		List<Deal> deals = theQuery.getResultList();
		/* return the result */
		return deals;
	}

	/**
	 * Returns a list of all active deals entries.
	 */
	public List<Deal> getActiveDeals() {
		logger.info("Entering to DealDAOImpl, into getActiveDeals method");
		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		/* create a query */
		Query<Deal> theQuery = currentSession.createQuery("from Deal where active= :code", Deal.class);
		theQuery.setParameter("code", 1);
		/* execute query and get result list */
		List<Deal> deals = theQuery.getResultList();
		/* return the result */
		return deals;
	}

	/**
	 * Finds a deal entry.
	 */
	public Deal findById(Long theId) {
		logger.info("Entering to DealDAOImpl, into findById method");
		Session currentSession = sessionFactory.getCurrentSession();
		Deal theDeal = currentSession.get(Deal.class, theId);
		return theDeal;
	}

	/**
	 * Saves a deal entry.
	 */
	public Deal saveDeal(Deal theDeal) {
		logger.info("Entering to saveDeal method");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theDeal);
		logger.info("Save Deal successful" + theDeal.toString());
		return theDeal;
	}

}
