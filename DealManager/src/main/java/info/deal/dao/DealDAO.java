package info.deal.dao;

import java.util.List;

import info.deal.entity.Deal;

/**
 * @author Andrzej 
 */
public interface DealDAO {
	/**
	 * Returns a list of all deals entries.
	 * 
	 * @return List found deals.
	 */
	public List<Deal> getDeals();

	/**
	 * Returns a list of all active deals entries.
	 * 
	 * @return List found active deals.
	 */
	public List<Deal> getActiveDeals();

	/**
	 * Finds a deal entry.
	 * 
	 * @param theId
	 *            The theId of the wanted deals entry.
	 * @return The found deal.
	 */
	public Deal findById(Long theId);

	/**
	 * Saves a deal entry.
	 * 
	 * @param theDeal
	 *            The information of the saved deal entry.
	 * @return Saved Deal
	 * 
	 */
	public Deal saveDeal(Deal theDeal);

}
