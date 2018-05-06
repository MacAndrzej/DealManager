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
	 * @return
	 */
	List<Systems> getSystems();

}
