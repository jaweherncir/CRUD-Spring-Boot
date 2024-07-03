package com.example.demo.controllers;

import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<ClientResponseDto> getClients() {
        return clientService.findAll();
    }

    @PostMapping("")
    public ClientResponseDto save(@RequestBody() ClientRequestDto clientRequestDto) {
        return clientService.save(clientRequestDto);
    }

}
