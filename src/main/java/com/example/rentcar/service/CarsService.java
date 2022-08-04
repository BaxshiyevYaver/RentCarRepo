package com.example.rentcar.service;

import com.example.rentcar.dao.entity.CarsEntity;
import com.example.rentcar.dao.entity.InformationEntity;
import com.example.rentcar.dao.repository.CarsRepository;
import com.example.rentcar.mapper.CarsMapper;
import com.example.rentcar.mapper.InformationMapper;
import com.example.rentcar.model.CarsDto;
import com.example.rentcar.model.InformationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsService {
    CarsRepository carsRepository;

    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<CarsDto> getCarsList() {
        List<CarsEntity> cars = carsRepository.findAll();

        var carsDtoList = cars.stream()
                .map(CarsMapper.INSTANCE::mapCarsMapperEntityToDto)
                .collect(Collectors.toList());

        return carsDtoList;

    }

}
