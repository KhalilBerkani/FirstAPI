package com.ma.firstapi.controllers;

import com.ma.firstapi.DTO.ClientRequestDTO;
import com.ma.firstapi.DTO.ClientResponseDTO;
import com.ma.firstapi.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")


public class ClientController {
    private ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping("")
    public List<ClientResponseDTO> getClient()
    {
        return clientService.findAll();
    }
    @PostMapping("")
    public ClientResponseDTO save(@RequestBody() ClientRequestDTO ClientRequestDTO){
        return clientService.save(ClientRequestDTO);
    }
    @GetMapping("/id/{id}")
    public ClientResponseDTO findById(@PathVariable("id") Integer id) {
        return clientService.findById(id);
    }
    @GetMapping("/nom/{nom}")
    public ClientResponseDTO findByNom(@PathVariable("nom")String nom) {
        return clientService.findByNom(nom);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.delete(id);
    }

    @PutMapping("/id/{id}")
    public ClientResponseDTO update(@RequestBody() ClientRequestDTO clientRequestDTO,@PathVariable() Integer id) {
        return clientService.update(clientRequestDTO, id);
    }
}
