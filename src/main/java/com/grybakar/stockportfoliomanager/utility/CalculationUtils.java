package com.grybakar.stockportfoliomanager.utility;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
public class CalculationUtils {

  public static final int ROUNDING_DECIMAL_PLACES = 2;
  public double round(double value, int places) {
    if (places <= 0 ) {
      throw new IllegalArgumentException();
    }
    return Precision.round(value, places);
  }

}
