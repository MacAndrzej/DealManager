package info.deal.service;

import java.util.List;

import info.deal.api.v1.controller.model.SystemDto;
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
	public List<SystemDto> getSystems();

	/**
	 * 
	 * @param theId
	 *            The theId of the wanted system entry.
	 * @return The found system.
	 */
	public SystemDto findById(Long theId);

	/**
	 * 
	 * @param theSystemDto
	 *            The information of the saved system entry.
	 * @return The saved system entry.
	 */
	public SystemDto saveSystemDto(SystemDto theSystemDto);
	
	/**
	 * 
	 * @param theSystems
	 * The information of the saved system entry.
	 * @return The saves system entry.
	 */
	public Systems saveSystem(Systems theSystems);
	

}
