package info.deal.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.deal.entity.Deal;
import info.deal.entity.Systems;

/**
 * 
 * @author Andrzej Repository layer of the application.
 */
@Repository
public class SystemDAOImpl implements SystemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Returns a list of all systems entries.
	 */
	public List<Systems> getSystems() {
		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		/* create a query */
		Query<Systems> theQuery = currentSession.createQuery("from Systems", Systems.class);
		/* execute query and get result list */
		List<Systems> systems = theQuery.getResultList();
		/* return the result */
		return systems;
	}

	public Systems findById(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Systems> theQuery = currentSession.createQuery("from Systems where id= :code", Systems.class);
		theQuery.setParameter("code", theId);
		List<Systems> system = theQuery.getResultList();
		return system.get(0);
	}
	

	public void saveSystem(Systems theSystems) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("DAO: " + theSystems);
		currentSession.saveOrUpdate(theSystems);
	}

}
