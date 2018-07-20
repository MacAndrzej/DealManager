package info.deal.api.v1.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import info.deal.api.v1.controller.model.DealDto;
import info.deal.entity.Deal;

/**
 * 
 * @Created by am on 25 cze 2018
 *
 */
@Mapper
public interface DealMapper {

	DealMapper INSTANCE = Mappers.getMapper(DealMapper.class);

	DealDto dealToDealDto(Deal deal);

	Deal dealDtoToDeal(DealDto dealDto);
}
