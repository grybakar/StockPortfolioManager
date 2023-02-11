package com.grybakar.stockportfoliomanager.mapper;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

  ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

  ClientDTO toClientDTO(Client client);

  @Mapping(target = "portfolios", ignore = true)
  Client toEntity(ClientDTO clientDTO);
}
