package com.ma.firstapi.service;

import com.ma.firstapi.DTO.ClientRequestDTO;
import com.ma.firstapi.DTO.ClientResponseDTO;
import java.util.List;

public interface ClientService {
    ClientResponseDTO save(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO findById(Integer id);
    ClientResponseDTO findByNom(String nom) ;
    void delete(Integer id) ;
    ClientResponseDTO update(ClientRequestDTO clientRequestDTO, Integer id) ;
    List<ClientResponseDTO> findAll();
}
