package info.deal.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.deal.config.HibernateConfiguration;
import info.deal.entity.Deal;
import info.deal.entity.Systems;

@Repository
public class DealDAOImpl implements DealDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<Deal> getDeals() {
		
		
		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("Ustawiona sesja, przed zapytaniem");
		/* create a query */
		Query<Deal> theQuery = currentSession.createQuery("from Deal", Deal.class);
		System.out.println("Po zapytaniu, przed załadowaniem do listy");
		/* execute query and get result list */
		List<Deal> deals = theQuery.getResultList();
		System.out.println("Po załadowaniu do listy, przed zwrotem");
		/* return the result */
		return deals;
	}

	@Transactional
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

}
