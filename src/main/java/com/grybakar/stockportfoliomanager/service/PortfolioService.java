package com.grybakar.stockportfoliomanager.service;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.dto.PortfolioDTO;
import com.grybakar.stockportfoliomanager.exception.StockPortfolioManagerException;
import com.grybakar.stockportfoliomanager.mapper.PortfolioMapper;
import com.grybakar.stockportfoliomanager.model.Client;
import com.grybakar.stockportfoliomanager.model.Portfolio;
import com.grybakar.stockportfoliomanager.repository.PortfolioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PortfolioService {

  private final PortfolioRepository portfolioRepository;
  private final PortfolioMapper portfolioMapper;

  public List<PortfolioDTO> getAll() {
    log.info("Finding clients");
    return portfolioRepository
      .findAll()
      .stream()
      .map(portfolioMapper::toPortfolioDTO)
      .toList();
  }

  public PortfolioDTO getPortfolioById(Long id) {
    log.info("Finding client by Id: {}", id);
    return portfolioRepository
      .findById(id)
      .map(portfolioMapper::toPortfolioDTO)
      .orElseThrow(() -> new StockPortfolioManagerException("No portfolio found by given id: %d".formatted(id)));
  }

  public PortfolioDTO savePortfolio(PortfolioDTO portfolioDTO) {
    log.info("Adding new Portfolio: {}", portfolioDTO);
    Portfolio newPortfolio = portfolioRepository.save(portfolioMapper.toPortfolioEntity(portfolioDTO));
    return portfolioMapper.toPortfolioDTO(newPortfolio);
  }

  public void deletePortfolio(Long id) {
    Portfolio portfolio = portfolioRepository
      .findById(id)
      .orElseThrow(() -> new StockPortfolioManagerException("No portfolio found by given id: %d".formatted(id)));
    log.info("Deleting portfolio with id: {}", id);
    portfolioRepository.delete(portfolio);
  }


}
