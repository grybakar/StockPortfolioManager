package com.grybakar.stockportfoliomanager.repository;

import com.grybakar.stockportfoliomanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
