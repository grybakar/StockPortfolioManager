package com.grybakar.stockportfoliomanager.controller;

import com.grybakar.stockportfoliomanager.dto.PositionDTO;
import com.grybakar.stockportfoliomanager.service.implementation.PositionServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/positions")
@RequiredArgsConstructor
public class PositionController {

  private final PositionServiceImpl positionServiceImpl;

  @GetMapping
  public ResponseEntity<List<PositionDTO>> getAllPositions() {
    return ResponseEntity.ok(positionServiceImpl.getAllPositions());
  }

  @GetMapping("{id}")
  public ResponseEntity<PositionDTO> getPositionById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(positionServiceImpl.getPositionById(id));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deletePosition(@PathVariable(name = "id") Long id) {
    positionServiceImpl.deletePosition(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<PositionDTO> updatePosition(@PathVariable Long id, @RequestBody PositionDTO positionDTO) {
    return ResponseEntity.ok(positionServiceImpl.updatePosition(id, positionDTO));
  }


}
