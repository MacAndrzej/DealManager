package info.deal.service;

import java.util.List;

import info.deal.entity.Deal;

public interface DealService {

	public List<Deal> getDeals();

	public List<Deal> getActiveDeals();

	public Deal findById(long theId);

	public Deal disableDeal(long theId);

	public Deal saveDeal(Deal theDeal);

}
