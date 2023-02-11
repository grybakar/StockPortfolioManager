package com.grybakar.stockportfoliomanager.controller;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/clients")
public class ClientController {

  private final ClientService clientService;

  @GetMapping
  public ResponseEntity<List<ClientDTO>> getAllClients() {
    return ResponseEntity.ok(clientService.getClients());
  }

  @PostMapping
  public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
    return ResponseEntity.ok(clientService.saveClient(clientDTO));
  }

}
