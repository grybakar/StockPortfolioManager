package com.grybakar.stockportfoliomanager.service;

import com.grybakar.stockportfoliomanager.dto.PortfolioDTO;
import java.util.List;

public interface PortfolioService {

  List<PortfolioDTO> getAll();

  PortfolioDTO getPortfolioById(Long id);

  PortfolioDTO savePortfolio(PortfolioDTO portfolioDTO);

  void deletePortfolio(Long id);

}
