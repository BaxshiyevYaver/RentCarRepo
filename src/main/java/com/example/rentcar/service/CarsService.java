package com.example.rentcar.service;

import com.example.rentcar.dao.repository.CarsRepository;
import org.springframework.stereotype.Service;

@Service
public class CarsService {
    CarsRepository carsRepository;

    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }
}
