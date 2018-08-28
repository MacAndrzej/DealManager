package info.deal.service;

import java.util.List;

import info.deal.entity.Systems;

/**
 * 
 * @author Andrzej
 *
 */
public interface SystemService {
	/**
	 * Returns a list of systems entries.
	 * 
	 * @return List of systems
	 */
	public List<Systems> getSystems();

	/**
	 * 
	 * @param theId
	 *            The theId of the wanted system entry.
	 * @return The found system.
	 */
	public Systems findById(Long theId);
	
	/**
	 * 
	 * @param theSystems
	 * The information of the saved system entry.
	 * @return The saves system entry.
	 */
	public Systems saveSystem(Systems theSystems);
	

}
