package info.deal.service;

import java.util.List;

import javax.validation.Valid;

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
	 * @return
	 */
	List<Systems> getSystems();

	/**
	 * 
	 * @param theId
	 *            The theId of the wanted system entry.
	 * @return The found system.
	 */
	Systems findById(long theId);

	/**
	 * 
	 * @param theSystems
	 *            The information of the saved system entry.
	 * @return The saved system entry.
	 */
	Systems saveSystem(@Valid Systems theSystems);

}
