package com.grybakar.stockportfoliomanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "position")
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String ticker;

  private String companyName;
  private LocalDate purchaseDate;
  private Integer sharesOwned;
  private Double currentPrice; // Market price of the stock
  private Double marketValue; // shares * currentPrice;
  private Double sharePrice; //  The original price you paid for each share, including any commissions or fees.
  private Double shareCostBasis; // Price of one share paid at the time of purchase;
  private Double totalCostBasis; // Total price  - shareCostBasis * shareOwned;
  private Double gainLoss; // marketValue - totalCostBasis
  private Double gainLossPercentage;

  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;


}
