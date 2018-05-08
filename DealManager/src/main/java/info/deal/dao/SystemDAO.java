package info.deal.dao;

import java.util.List;

import javax.validation.Valid;

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

	public Systems findById(long theId);

	public void saveSystem(@Valid Systems theSystems);

}
