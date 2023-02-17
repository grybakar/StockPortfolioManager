package com.grybakar.stockportfoliomanager.model;

import lombok.Data;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Data
public class PositionPage {

  private int pageNumber = 0;
  private int pageSize = 10;
  private Sort.Direction sortDirection = Direction.ASC;
  private String sortBy = "symbol";

}
