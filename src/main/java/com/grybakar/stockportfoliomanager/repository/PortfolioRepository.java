package com.grybakar.stockportfoliomanager.repository;

import com.grybakar.stockportfoliomanager.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
