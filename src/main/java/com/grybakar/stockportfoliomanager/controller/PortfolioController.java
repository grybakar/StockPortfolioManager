package com.grybakar.stockportfoliomanager.controller;

import com.grybakar.stockportfoliomanager.dto.PortfolioDTO;
import com.grybakar.stockportfoliomanager.service.PortfolioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

  private final PortfolioService portfolioService;

  @GetMapping
  public ResponseEntity<List<PortfolioDTO>> getAllPortfolios() {
    return ResponseEntity.ok(portfolioService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<PortfolioDTO> getClientById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(portfolioService.getPortfolioById(id));
  }

  @PostMapping
  public ResponseEntity<PortfolioDTO> saveClient(@RequestBody PortfolioDTO portfolioDTO) {
    return ResponseEntity.ok(portfolioService.savePortfolio(portfolioDTO));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable(name = "id") Long id) {
    portfolioService.deletePortfolio(id);
    return ResponseEntity.noContent().build();
  }

}
