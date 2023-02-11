package com.grybakar.stockportfoliomanager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String fullName;
  private String username;
  private String password;
  private String email;

  @OneToMany(
    mappedBy = "client",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
  List<Portfolio> portfolios;

  public void addPortfolio(Portfolio portfolio) {
    portfolios.add(portfolio);
    portfolio.setClient(this);
  }

  public void removePortfolio(Portfolio portfolio) {
    portfolios.remove(portfolio);
    portfolio.setClient(null);
  }

}
