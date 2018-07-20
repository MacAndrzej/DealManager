package info.deal.api.v1.controller.model;

import java.util.List;

/**
 * 
 * @Created by am on 25 cze 2018
 *
 */
public class SystemListDto {
	List<SystemDto> system;

	public SystemListDto() {
	}

	public SystemListDto(List<SystemDto> system) {
		this.system = system;
	}

	public List<SystemDto> getSystem() {
		return system;
	}

	public void setSystem(List<SystemDto> system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return "SystemListDto [system=" + system + "]";
	}

}
