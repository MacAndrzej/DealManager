package info.deal.api.v1.controller.model;

import java.util.List;

public class DealListDto {
	List<DealDto> deals;

	public DealListDto() {
	}

	public DealListDto(List<DealDto> deals) {
		this.deals = deals;
	}

	public List<DealDto> getDeals() {
		return deals;
	}

	public void setDeals(List<DealDto> deals) {
		this.deals = deals;
	}

	@Override
	public String toString() {
		return "DealListDto [deals=" + deals + "]";
	}
	
	

}
