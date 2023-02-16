package com.grybakar.stockportfoliomanager.controller;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.service.implementation.ClientServiceImpl;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

  private final ClientServiceImpl clientServiceImpl;

  @GetMapping
  public ResponseEntity<List<ClientDTO>> getAllClients() {
    return ResponseEntity.ok(clientServiceImpl.getClients());
  }

  @GetMapping("{id}")
  public ResponseEntity<ClientDTO> getClientById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(clientServiceImpl.getClientById(id));
  }

  @PostMapping
  public ResponseEntity<ClientDTO> saveClient(@Valid @RequestBody ClientDTO clientDTO) {
    return ResponseEntity.ok(clientServiceImpl.saveClient(clientDTO));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable(name = "id") Long id) {
    clientServiceImpl.deleteClient(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("{id}")
  public ResponseEntity<ClientDTO> updateClient(
    @PathVariable(name = "id") Long id,
    @Valid @RequestBody ClientDTO clientDTO) {
    return ResponseEntity.ok(clientServiceImpl.updateClient(id, clientDTO));
  }
}
