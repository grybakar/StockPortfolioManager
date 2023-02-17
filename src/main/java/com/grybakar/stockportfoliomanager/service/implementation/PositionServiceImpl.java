package com.grybakar.stockportfoliomanager.service.implementation;

import static org.springframework.web.util.UriComponentsBuilder.*;

import com.grybakar.stockportfoliomanager.dto.PortfolioDTO;
import com.grybakar.stockportfoliomanager.dto.PositionDTO;
import com.grybakar.stockportfoliomanager.exception.StockPortfolioManagerNotFoundException;
import com.grybakar.stockportfoliomanager.mapper.PortfolioMapper;
import com.grybakar.stockportfoliomanager.mapper.PositionMapper;
import com.grybakar.stockportfoliomanager.model.Portfolio;
import com.grybakar.stockportfoliomanager.model.Position;
import com.grybakar.stockportfoliomanager.populator.PositionPopulator;
import com.grybakar.stockportfoliomanager.repository.PositionRepository;
import com.grybakar.stockportfoliomanager.service.PortfolioService;
import com.grybakar.stockportfoliomanager.service.PositionService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionServiceImpl implements PositionService {

  private static final String PATH_POSITION = "http://localhost:8080/api/positions/{id}";
  private final PositionRepository positionRepository;
  private final PositionMapper positionMapper;
  private final PositionPopulator positionPopulator;
  private final PortfolioService portfolioService;
  private final PortfolioMapper portfolioMapper;


  public List<PositionDTO> getAllPositions() {
    log.info("Finding positions");
    return positionRepository.findAll().stream().map(positionMapper::toPositionDTO).toList();
  }

  public PositionDTO getPositionById(Long id) {
    log.info("Finding position by Id: {}", id);
    return positionRepository.findById(id).map(positionMapper::toPositionDTO)
      .orElseThrow(() -> new StockPortfolioManagerNotFoundException("No position found by given id: %d".formatted(id)));
  }

  @Transactional
  public PositionDTO savePositionToPortfolio(Long portfolioId, PositionDTO positionDTO) {
    PortfolioDTO currentPortfolio = portfolioService.getPortfolioById(portfolioId);
    Portfolio portfolio = portfolioMapper.toPortfolioEntity(currentPortfolio);

    positionDTO.setPortfolioId(portfolioId);
    positionPopulator.populatePositionData(positionDTO);

    log.info("Saving position: {} to Portfolio: {}", positionDTO, portfolioId);

    Position position = positionMapper.toPositionEntity(positionDTO);
    portfolio.addPosition(position);

    Position savedPosition = positionRepository.save(position);
    return positionMapper.toPositionDTO(savedPosition);
  }

  public void deletePosition(Long id) {
    Position position = positionRepository.findById(id)
      .orElseThrow(() -> new StockPortfolioManagerNotFoundException("No position found by given id: %d".formatted(id)));
    log.info("Deleting position with id: {}", id);
    positionRepository.delete(position);
  }

  public URI createPositionURI(Long id) {
    return fromPath(PATH_POSITION).buildAndExpand(id).toUri();
  }

  @Transactional
  public PositionDTO updatePosition(Long id, PositionDTO positionDTO) {
    PositionDTO updatedPosition = getPositionById(id);

    positionPopulator.populatePositionData(positionDTO);
    positionDTO.setId(updatedPosition.getId());

    Position position = positionMapper.toPositionEntity(updatedPosition);
    return positionMapper.toPositionDTO(positionRepository.save(position));
  }
}
