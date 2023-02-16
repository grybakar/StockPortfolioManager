package com.grybakar.stockportfoliomanager.service.implementation;

import static com.grybakar.stockportfoliomanager.utility.CalculationUtils.*;

import com.grybakar.stockportfoliomanager.dto.PositionDTO;
import com.grybakar.stockportfoliomanager.service.ApiConnectionService;
import com.grybakar.stockportfoliomanager.service.PositionCalculationService;
import com.grybakar.stockportfoliomanager.utility.CalculationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionCalculationServiceImpl implements PositionCalculationService {

  private final CalculationUtils calculationUtils;
  private final ApiConnectionService apiConnectionService;

  /**
   * Calculates the market value of a given stock position
   *
   * @param positionDTO The stock position data.
   * @return The market value of stock position rounded up.
   */
  @Override
  public Double calculateMarketValue(PositionDTO positionDTO) {
    double marketValue = apiConnectionService.getPrice(positionDTO.getTicker()) * positionDTO.getSharesOwned();
    return calculationUtils.round(marketValue, ROUNDING_DECIMAL_PLACES);
  }

  /**
   * Calculates the total cost basis of a given stock position.
   *
   * @param positionDTO The stock position data.
   * @return The total cost basis of the stock position rounded up.
   */
  @Override
  public Double calculateTotalCostBasis(PositionDTO positionDTO) {
    double totalCostBasis = positionDTO.getShareCostBasis() * positionDTO.getSharesOwned();
    return calculationUtils.round(totalCostBasis, ROUNDING_DECIMAL_PLACES);
  }

  /**
   * Calculates the gain or loss of a given stock position.
   *
   * @param positionDTO The stock position data.
   * @return The gain or loss of the stock position rounded up.
   */
  @Override
  public Double calculateGainLoss(PositionDTO positionDTO) {
    double gainLoss = calculateMarketValue(positionDTO) - calculateTotalCostBasis(positionDTO);
    return calculationUtils.round(gainLoss, ROUNDING_DECIMAL_PLACES);
  }

  /**
   * Calculates the gain or loss percentage of a given stock position.
   *
   * @param positionDTO The stock position data.
   * @return The gain or loss percentage of the stock position rounded up.
   */

  @Override
  public Double calculateGainLossPercentage(PositionDTO positionDTO) {
    double gainLossPercentage = (calculateGainLoss(positionDTO) / calculateTotalCostBasis(positionDTO)) * 100;
    return calculationUtils.round(gainLossPercentage, ROUNDING_DECIMAL_PLACES);
  }

}
