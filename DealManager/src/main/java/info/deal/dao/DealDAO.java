package info.deal.dao;

import java.util.List;

import info.deal.entity.Deal;

public interface DealDAO {
	
	public List<Deal> getDeals();

	public List<Deal> getActiveDeals();

}
