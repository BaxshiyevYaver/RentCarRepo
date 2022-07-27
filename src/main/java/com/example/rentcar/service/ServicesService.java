package com.example.rentcar.service;

import com.example.rentcar.dao.repository.ServicesRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicesService {
    ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }
}
