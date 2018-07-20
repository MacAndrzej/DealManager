package info.deal.api.v1.controller.mapper;

import org.springframework.stereotype.Component;

import info.deal.api.v1.controller.model.DealDto;
import info.deal.entity.Deal;

@Component
public class DealMapperImpl implements DealMapper {

	@Override
	public DealDto dealToDealDto(Deal deal) {
		if (deal == null) {
			return null;
		}
		DealDto dealDto = new DealDto();
		dealDto.setId(deal.getId());
		dealDto.setActive(deal.getActive());
		dealDto.setAmount(deal.getAmount());
		dealDto.setAmountPeriod(deal.getAmountPeriod());
		dealDto.setFromDate(deal.getFromDate());
		dealDto.setOrderNumber(deal.getOrderNumber());
		dealDto.setToDate(deal.getToDate());
		dealDto.setSystems(deal.getSystems());
		return dealDto;
	}

	@Override
	public Deal dealDtoToDeal(DealDto dealDto) {
		if (dealDto == null) {
			return null;
		}
		Deal deal = new Deal();
		deal.setId(dealDto.getId());
		deal.setActive(dealDto.getActive());
		deal.setAmount(dealDto.getAmount());
		deal.setAmountPeriod(dealDto.getAmountPeriod());
		deal.setFromDate(dealDto.getFromDate());
		deal.setOrderNumber(dealDto.getOrderNumber());
		deal.setSystems(dealDto.getSystems());
		deal.setToDate(dealDto.getToDate());
		return deal;
	}

}
