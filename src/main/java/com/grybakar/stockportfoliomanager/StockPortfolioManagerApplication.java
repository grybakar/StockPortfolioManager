package com.grybakar.stockportfoliomanager;

import com.grybakar.stockportfoliomanager.service.ApiConnectionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockPortfolioManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(StockPortfolioManagerApplication.class, args);
  }
}
