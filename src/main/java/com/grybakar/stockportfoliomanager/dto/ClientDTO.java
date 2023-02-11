package com.grybakar.stockportfoliomanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {

  private Long id;
  private String fullName;
  private String username;
  private String password;
  private String email;

}
