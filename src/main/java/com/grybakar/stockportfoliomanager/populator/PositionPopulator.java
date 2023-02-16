package com.grybakar.stockportfoliomanager.populator;

import com.grybakar.stockportfoliomanager.dto.PositionDTO;
import com.grybakar.stockportfoliomanager.service.ApiConnectionService;
import com.grybakar.stockportfoliomanager.service.PositionCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionPopulator {

  private final PositionCalculationService positionCalculationService;
  private final ApiConnectionService apiConnectionService;

  public PositionDTO populatePositionData(PositionDTO positionDTO) {
    positionDTO.setMarketValue(positionCalculationService.calculateMarketValue(positionDTO));
    positionDTO.setCurrentPrice(apiConnectionService.getPrice(positionDTO.getTicker()));
    positionDTO.setTotalCostBasis(positionCalculationService.calculateTotalCostBasis(positionDTO));
    positionDTO.setGainLoss(positionCalculationService.calculateGainLoss(positionDTO));
    positionDTO.setGainLossPercentage(positionCalculationService.calculateGainLossPercentage(positionDTO));
    return positionDTO;
  }

}
