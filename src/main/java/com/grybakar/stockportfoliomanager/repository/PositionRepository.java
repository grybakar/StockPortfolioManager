package com.grybakar.stockportfoliomanager.repository;

import com.grybakar.stockportfoliomanager.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {


}
