package com.example.rentcar.service;

import com.example.rentcar.dao.entity.ClientsEntity;
import com.example.rentcar.dao.repository.ClientsRepository;
import com.example.rentcar.mapper.ClientsMapper;
import com.example.rentcar.model.ClientsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsService {
    ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<ClientsDto> getClientsList() {
        List<ClientsEntity> clients = clientsRepository.findAll();

        var clientsDtoList = clients.stream()
                .map(ClientsMapper.INSTANCE::mapClientsMapperEntityToDto)
                .collect(Collectors.toList());

        return clientsDtoList;

    }




}
