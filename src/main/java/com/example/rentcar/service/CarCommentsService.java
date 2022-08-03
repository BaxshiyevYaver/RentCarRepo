package com.example.rentcar.service;

import com.example.rentcar.dao.repository.CarCommentsRepository;
import org.springframework.stereotype.Service;

@Service
public class CarCommentsService {
    CarCommentsRepository carCommentsRepository;

    public CarCommentsService(CarCommentsRepository carCommentsRepository) {
        this.carCommentsRepository = carCommentsRepository;
    }
}
