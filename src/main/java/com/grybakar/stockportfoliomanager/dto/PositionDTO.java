package com.grybakar.stockportfoliomanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PositionDTO {

  private Long id;
  private String ticker; //input
  private LocalDate purchaseDate; // input
  private Integer sharesOwned; // input
  private Double currentPrice;
  private Double marketValue;
  private Double shareCostBasis; // input
  private Double totalCostBasis;
  private Double gainLoss;
  private Double gainLossPercentage;

  @JsonIgnore
  private Long portfolioId;
}
