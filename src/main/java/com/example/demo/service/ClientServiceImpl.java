package com.example.demo.service;

import com.example.demo.Entity.ClientEntity;
import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.dao.ClientDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
@Service
public class ClientServiceImpl  implements  ClientService{
    private ClientDao clientDao;
    private ModelMapper modelMapper;
    @Autowired
    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper){
        this.clientDao=clientDao;
        this.modelMapper=modelMapper;
    }
    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        //convert client dto vers client entity
        ClientEntity clientEntity=modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved=clientDao.save(clientEntity);
        return modelMapper.map(saved,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
      ClientEntity clientEntity=clientDao.findById(id).orElseThrow(()-> new RuntimeException("client not found"));
        return modelMapper.map( clientEntity,ClientResponseDto.class);

    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity=clientDao.findByNom(nom);
        return modelMapper.map( clientEntity,ClientResponseDto.class);

    }

    @Override
    public void deleteById(Integer id) {
        //methode 1
   clientDao.findById(id);
   //methode 2
   //ClientEntity clientEntity=clientDao.findById(id).get();
   //clientDao.delete(clientEntity);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws ChangeSetPersister.NotFoundException, ChangeSetPersister.NotFoundException {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
        if (clientEntityOptional.isPresent()) {
            ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }


    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll().stream().map(el->modelMapper.map(el,ClientResponseDto.class)).collect(Collectors.toUnmodifiableList());
    }
}
