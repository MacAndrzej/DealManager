package info.deal.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import info.deal.dto.DealDto;
import info.deal.entity.Deal;

/**
 * @author Andrzej Interface
 * 
 *         Service layer of the application.
 */
public interface DealService {
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
	public Deal findById(long theId);

	/**
	 * Disables a deal entry.
	 * 
	 * @param theId
	 *            The theId of the disabled deal entry.
	 * @return The disabled deal entry.
	 */
	public Deal disableDeal(long theId);

	/**
	 * Saves a deal entry.
	 * 
	 * @param theDeal
	 *            The information of the saved deal entry.
	 * @return The saved deal entry.
	 */
	public Deal saveDeal(Deal theDeal);

	/**
	 * Importes deals from a file
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * 
	 */
	public List<DealDto> importCsv() throws FileNotFoundException, IOException;

}
