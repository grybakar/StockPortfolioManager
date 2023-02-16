package com.grybakar.stockportfoliomanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PortfolioDTO {

  private Long id;

  @NotBlank(message = "NAME Required")
  @Pattern(
    regexp = "^[a-zA-Z0-9]+(?:\s[a-zA-Z0-9]+)*$",
    message = "No special characters, No double spaces, only letters and digits")
  @Size(max = 50, message = "Name too long")
  private String name;

  private Set<PositionDTO> positions = new HashSet<>();
}
