package com.grybakar.stockportfoliomanager.service;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import com.grybakar.stockportfoliomanager.mapper.ClientMapper;
import com.grybakar.stockportfoliomanager.model.Client;
import com.grybakar.stockportfoliomanager.repository.ClientRepository;
import java.util.List;
import java.util.stream.Collectors;
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

  public ClientDTO saveClient(ClientDTO clientDTO) {
    log.info("Adding new Client: {}", clientDTO);
    Client newClient = clientRepository.save(clientMapper.toEntity(clientDTO));
    return clientMapper.toClientDTO(newClient);
  }


}
