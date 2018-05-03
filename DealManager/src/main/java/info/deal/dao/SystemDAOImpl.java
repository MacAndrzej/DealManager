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

@Repository
public class SystemDAOImpl implements SystemDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public List<Systems> getSystems() {

		/* get the current hibernate session */
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("Ustawiona sesja, przed zapytaniem");
		/* create a query */
		Query<Systems> theQuery = currentSession.createQuery("from Systems", Systems.class);
		System.out.println("Po zapytaniu, przed załadowaniem do listy");
		/* execute query and get result list */
		List<Systems> systems = theQuery.getResultList();
		System.out.println("Po załadowaniu do listy, przed zwrotem");
		System.out.println("Teraz wracamy do controllera");
		/* return the result */
		return systems;
	}

}
