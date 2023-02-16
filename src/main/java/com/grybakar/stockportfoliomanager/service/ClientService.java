package com.grybakar.stockportfoliomanager.service;

import com.grybakar.stockportfoliomanager.dto.ClientDTO;
import java.util.List;

public interface ClientService {

  List<ClientDTO> getClients();

  ClientDTO getClientById(Long id);

  ClientDTO saveClient(ClientDTO clientDTO);

  void deleteClient(Long id);

  ClientDTO updateClient(Long id, ClientDTO requestDetails);


}
