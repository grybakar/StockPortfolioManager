package com.grybakar.stockportfoliomanager.service;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.exception.StockPortfolioManagerException;
import com.grybakar.stockportfoliomanager.mapper.ClientMapper;
import com.grybakar.stockportfoliomanager.model.Client;
import com.grybakar.stockportfoliomanager.repository.ClientRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper;

  public List<ClientDTO> getClients() {
    log.info("Finding clients");
    return clientRepository
      .findAll()
      .stream()
      .map(clientMapper::toClientDTO)
      .toList();
  }

  public ClientDTO getClientById(Long id) {
    log.info("Finding client by Id: {}", id);
    return clientRepository
      .findById(id)
      .map(clientMapper::toClientDTO)
      .orElseThrow(() -> new StockPortfolioManagerException("No client found by given id: %d".formatted(id)));
  }

  public ClientDTO saveClient(ClientDTO clientDTO) {
    log.info("Adding new Client: {}", clientDTO);
    Client newClient = clientRepository.save(clientMapper.toEntity(clientDTO));
    return clientMapper.toClientDTO(newClient);
  }

  public void deleteClient(Long id) {
    Client client = clientRepository
      .findById(id)
      .orElseThrow(() -> new StockPortfolioManagerException("No client found by given id: %d".formatted(id)));
    log.info("Deleting client with id: {}", id);
    clientRepository.delete(client);
  }

  public ClientDTO updateClient(Long id, ClientDTO requestDetails) {

    ClientDTO clientToUpdate = getClientById(id);
    update(requestDetails, clientToUpdate);
    Client updatedClient = clientRepository.save(clientMapper.toEntity(clientToUpdate));
    log.info("Updated client info: {}", updatedClient);
    return clientMapper.toClientDTO(updatedClient);
  }

  private static void update(ClientDTO requestDetails, ClientDTO clientToUpdate) {
    clientToUpdate.setEmail(requestDetails.getEmail());
    clientToUpdate.setFullName(requestDetails.getFullName());
    clientToUpdate.setUsername(requestDetails.getUsername());
    clientToUpdate.setPassword(requestDetails.getPassword());
  }


}
