package info.deal.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.deal.entity.Deal;
import info.deal.service.DealServiceImpl;

/**
 * 
 * @author Andrzej Repository layer of the application.
 */
@Repository
public class DealDAOImpl implements DealDAO {

	final static Logger logger=Logger.getLogger(DealServiceImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Returns a list of all deals entries.
	 */
	public List<Deal> getDeals() {
		logger.info("Entering to DealDAOImpl, into getDeals method");
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
		System.out.println("Ustawiona sesja, przed zapytaniem");
		/* create a query */
		Query<Deal> theQuery = currentSession.createQuery("from Deal where active= :code", Deal.class);
		theQuery.setParameter("code", 1);
		System.out.println("Po zapytaniu, przed załadowaniem do listy");
		/* execute query and get result list */
		List<Deal> deals = theQuery.getResultList();
		System.out.println("Po załadowaniu do listy, przed zwrotem");
		/* return the result */
		return deals;
	}

	/**
	 * Finds a deal entry.
	 */
	public Deal findById(long theId) {
		logger.info("Entering to DealDAOImpl, into findById method");
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Deal> theQuery = currentSession.createQuery("from Deal where id= :code", Deal.class);
		theQuery.setParameter("code", theId);
		List<Deal> deals = theQuery.getResultList();
		return deals.get(0);
	}

	/**
	 * Saves a deal entry.
	 */
	public void saveDeal(Deal theDeal) {
		logger.info("Entering to saveDeal method");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("DAO: " + theDeal);
		currentSession.saveOrUpdate(theDeal);
		logger.info("Save Deal successful"+theDeal.toString());
	}

}
