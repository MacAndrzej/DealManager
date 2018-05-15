package info.deal.dao;

import java.util.List;

import javax.validation.Valid;

import info.deal.entity.Systems;
import info.deal.exception.SystemNotFoundException;

/**
 * 
 * @author Andrzej
 *
 */
public interface SystemDAO {
	/**
	 * Returns a list of all systems entries.
	 * 
	 * @return List found deals.
	 */
	public List<Systems> getSystems();

	/**
	 * 
	 * @param theId
	 *            The theId of the wanted system entry.
	 * @return The found deal.
	 */
	public Systems findById(long theId);

	/**
	 * 
	 * Saves a system entry.
	 * 
	 * @param theSystems
	 *            The information of the saved system entry.
	 */
	public void saveSystem(@Valid Systems theSystems);

}
