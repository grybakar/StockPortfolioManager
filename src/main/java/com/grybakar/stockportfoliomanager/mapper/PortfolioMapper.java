package com.grybakar.stockportfoliomanager.mapper;

import com.grybakar.stockportfoliomanager.dto.PortfolioDTO;
import com.grybakar.stockportfoliomanager.model.Portfolio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PortfolioMapper {

  PortfolioDTO toPortfolioDTO(Portfolio portfolio);

  @Mapping(target = "client", ignore = true)
  Portfolio toPortfolioEntity(PortfolioDTO portfolioDTO);

}
