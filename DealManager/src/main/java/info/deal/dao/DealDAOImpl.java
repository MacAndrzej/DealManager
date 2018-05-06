package info.deal.dao;

import java.util.List;

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

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Returns a list of all deals entries.
	 */
	public List<Deal> getDeals() {
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
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("DAO: " + theDeal);
		currentSession.saveOrUpdate(theDeal);

	}

}
