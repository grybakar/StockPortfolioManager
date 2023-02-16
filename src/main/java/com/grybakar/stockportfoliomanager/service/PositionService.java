package com.grybakar.stockportfoliomanager.service;

import com.grybakar.stockportfoliomanager.dto.PositionDTO;
import java.net.URI;
import java.util.List;

public interface PositionService {

  List<PositionDTO> getAllPositions();

  PositionDTO getPositionById(Long id);

  PositionDTO savePositionToPortfolio(Long portfolioId, PositionDTO positionDTO);

  void deletePosition(Long id);

  URI createPositionURI(Long id);

  PositionDTO updatePosition(Long id, PositionDTO positionDTO);
}
