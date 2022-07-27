package com.example.rentcar.service;

import com.example.rentcar.dao.repository.ClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }
}
