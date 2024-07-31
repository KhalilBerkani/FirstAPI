package com.ma.firstapi.service;

import com.ma.firstapi.DAO.ClientDAO;
import com.ma.firstapi.DTO.ClientRequestDTO;
import com.ma.firstapi.DTO.ClientResponseDTO;
import com.ma.firstapi.models.Client;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    private ClientDAO clientDAO;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ClientDAO clientDAO, ModelMapper modelMapper) {
        this.clientDAO = clientDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        Client client = modelMapper.map(clientRequestDTO,Client.class);
        Client saved = clientDAO.save(client);
        return modelMapper.map(saved,ClientResponseDTO.class);
    }

    @Override
    public ClientResponseDTO findById(Integer id) {
        Client client = clientDAO.findById(id).orElseThrow(()-> new RuntimeException("Client non trouver"));
        return modelMapper.map(client,ClientResponseDTO.class);
    }

    @Override
    public ClientResponseDTO findByNom(String nom) {
        Client client = clientDAO.findByNom(nom);
        return modelMapper.map(client,ClientResponseDTO.class);
    }

    @Override
    public void delete(Integer id) {
        clientDAO.deleteById(id);
    }

    @Override
    public ClientResponseDTO update(ClientRequestDTO clientRequestDTO, Integer id)  {
        Optional<Client> clientOpt  = clientDAO.findById(id);
            Client client = modelMapper.map(clientRequestDTO, Client.class);
            client.setId(id);
            Client updated = clientDAO.save(client);
            return  modelMapper.map(updated,ClientResponseDTO.class);

    }

    @Override
    public List<ClientResponseDTO> findAll() {
        return clientDAO.findAll().stream().map(
                el -> modelMapper.map(el,ClientResponseDTO.class)
        ).collect(Collectors.toList());
    }
}