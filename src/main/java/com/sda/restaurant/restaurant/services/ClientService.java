package com.sda.restaurant.restaurant.services;

import com.sda.restaurant.restaurant.DTO.ClientDTO;
import com.sda.restaurant.restaurant.model.ClientEntity;
import com.sda.restaurant.restaurant.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    public Long saveClient(ClientDTO client) {
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class);

        return clientRepository.save(clientEntity).getId();
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientEntity findByEmail(String email) {
        ClientEntity clientToFind = clientRepository.findByEmail(email);
        return modelMapper.map(clientToFind, ClientEntity.class);
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll(Sort.by(Sort.Direction.ASC, "email")).stream()
                .map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }
}
