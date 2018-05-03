package info.deal.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.deal.dao.DealDAO;
import info.deal.entity.Deal;


@Service
public class DealServiceImpl implements DealService {
	
	@Autowired
	private DealDAO dealDAO;

	@Transactional
	public List<Deal> getDeals() {
		List<Deal> deals=new ArrayList<Deal>();
		for (Deal d : dealDAO.getDeals()) {
			deals.add(d);
		}
		
		return deals;
	}

	@Transactional
	public List<Deal> getActiveDeals() {
		List<Deal> deals=new ArrayList<Deal>();
		for (Deal d : dealDAO.getActiveDeals()) {
			deals.add(d);
		}
		return deals;
	}

}
