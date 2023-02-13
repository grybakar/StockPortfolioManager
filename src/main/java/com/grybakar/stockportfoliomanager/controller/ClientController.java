package com.grybakar.stockportfoliomanager.controller;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("{id}")
  public ResponseEntity<ClientDTO> getClientById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(clientService.getClientById(id));
  }

  @PostMapping
  public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
    return ResponseEntity.ok(clientService.saveClient(clientDTO));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable(name = "id") Long id) {
    clientService.deleteClient(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("{id}")
  public ResponseEntity<ClientDTO> updateClient(
    @PathVariable(name = "id") Long id,
    @RequestBody ClientDTO clientDTO) {
    return ResponseEntity.ok(clientService.updateClient(id, clientDTO));
  }
}
