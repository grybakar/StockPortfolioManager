package com.grybakar.stockportfoliomanager.service;

import com.grybakar.stockportfoliomanager.dto.PositionDTO;

public interface PositionCalculationService {

  Double calculateMarketValue(PositionDTO positionDTO);

  Double calculateTotalCostBasis(PositionDTO positionDTO);

  Double calculateGainLoss(PositionDTO positionDTO);

  Double calculateGainLossPercentage(PositionDTO positionDTO);


}
