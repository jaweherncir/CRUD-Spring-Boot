package com.example.demo.service;

import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ClientService {
 ClientResponseDto save(ClientRequestDto clientRequestDto);
 ClientResponseDto findById(Integer id);
 ClientResponseDto findByNom(String nom);
 void  deleteById(Integer id);
 ClientResponseDto  update(ClientRequestDto clientRequestDto,Integer id) throws ChangeSetPersister.NotFoundException;
  List<ClientResponseDto> findAll();
}
