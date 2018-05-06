package info.deal.dao;

import java.util.List;

import info.deal.entity.Systems;

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

}
