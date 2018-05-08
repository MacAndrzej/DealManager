package info.deal.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.deal.dao.DealDAO;
import info.deal.entity.Deal;

/**
 * 
 * @author Andrzej
 * 
 *         Service layer of the application.
 *
 */
@Service
@Transactional
public class DealServiceImpl implements DealService {

	@Autowired
	private DealDAO dealDAO;

	public List<Deal> getDeals() {
		List<Deal> deals = new ArrayList<Deal>();
		for (Deal d : dealDAO.getDeals()) {
			deals.add(d);
		}
		return deals;
	}

	public List<Deal> getActiveDeals() {
		List<Deal> deals = new ArrayList<Deal>();
		for (Deal d : dealDAO.getActiveDeals()) {
			deals.add(d);
		}
		return deals;
	}

	public Deal findById(long theId) {
		Deal theDeal = dealDAO.findById(theId);
		return theDeal;
	}

	public Deal saveDeal(Deal theDeal) {
		dealDAO.saveDeal(theDeal);
		return theDeal;
	}

	public Deal disableDeal(long theId) {
		Deal theDeal = dealDAO.findById(theId);
		theDeal.setActive(0);
		return theDeal;
	}

}
