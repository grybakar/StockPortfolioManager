package com.grybakar.stockportfoliomanager.mapper;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

  ClientDTO toClientDTO(Client client);

  @Mapping(target = "portfolios", ignore = true)
  Client toClientEntity(ClientDTO clientDTO);
}
