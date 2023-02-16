package com.grybakar.stockportfoliomanager.mapper;

import com.grybakar.stockportfoliomanager.dto.PositionDTO;
import com.grybakar.stockportfoliomanager.model.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PositionMapper {

  @Mapping(target = "portfolioId", source = "portfolio.id")
  PositionDTO toPositionDTO(Position position);

  @Mapping(target = "portfolio", ignore = true)
  Position toPositionEntity(PositionDTO positionDTO);
}
