package com.example.rentcar.service;

import com.example.rentcar.dao.entity.CarsEntity;
import com.example.rentcar.dao.repository.CarsRepository;
import com.example.rentcar.mapper.CarsMapper;
import com.example.rentcar.model.CarsDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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

    public void deleteCar(Integer id) {
        carsRepository.deleteById(id);
    }

    public CarsDto getCar(Integer id) {
        Optional<CarsEntity> optionalCarsEntity = carsRepository.findById(id);
        var carsEntity = optionalCarsEntity.orElseGet(CarsEntity::new);
        var carsDto = CarsMapper.INSTANCE.mapCarsMapperEntityToDto(carsEntity);
        return carsDto;
    }

    @Transactional
    public void saveCar(CarsDto carsDto) {

        carsRepository.save(CarsMapper.INSTANCE.mapCarsMapperDtoToEntity(carsDto));

    }
}
