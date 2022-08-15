package com.example.rentcar.service;

import com.example.rentcar.dao.entity.CarsEntity;
import com.example.rentcar.dao.entity.RentCarEntity;
import com.example.rentcar.dao.repository.CarCommentsRepository;
import com.example.rentcar.dao.repository.CarsRepository;
import com.example.rentcar.dao.repository.RentCarRepository;
import com.example.rentcar.mapper.CarsMapper;
import com.example.rentcar.model.CarsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("carsService")
public class CarsService {

    CarsRepository carsRepository;
    @Autowired
    RentCarRepository rentCarRepository;
    @Autowired
    CarCommentsRepository carCommentsRepository;


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

    public List<RentCarEntity> getRentCarList() {


        return rentCarRepository.findAll();

    }


    public void deleteCar(Integer id) {
        rentCarRepository.deleteAll(rentCarRepository.checkCar(id));
        carCommentsRepository.deleteAll(carCommentsRepository.checkComments(id));
        carsRepository.deleteById(id);
    }

    public CarsDto getCar(Integer id) {
        Optional<CarsEntity> optionalCarsEntity = carsRepository.findById(id);
        var carsEntity = optionalCarsEntity.orElseGet(CarsEntity::new);
        var carsDto = CarsMapper.INSTANCE.mapCarsMapperEntityToDto(carsEntity);
        return carsDto;
    }

    public long totalCar() {
        return carsRepository.count();
    }

    @Transactional
    public void saveCar(CarsDto carsDto, MultipartFile car_image) throws IOException {
        carsDto.setCar_image(Base64.getEncoder().encodeToString(car_image.getBytes()));
        carsRepository.save(CarsMapper.INSTANCE.mapCarsMapperDtoToEntity(carsDto));
    }

    @Transactional
    public void editSaveCar(Integer id, MultipartFile car_image, CarsDto carsDto) throws IOException {

        var carEntity = carsRepository.findById(id).get();
        var carDtoOld = CarsMapper.INSTANCE.mapCarsMapperEntityToDto(carEntity);

        if (car_image.isEmpty()) {
            carsDto.setCar_image(carDtoOld.getCar_image());
        } else {
            carsDto.setCar_image(Base64.getEncoder().encodeToString(car_image.getBytes()));
        }
        carsRepository.save(CarsMapper.INSTANCE.mapCarsMapperDtoToEntity(carsDto));
    }

    @Transactional
    public String checkRentCar(RentCarEntity rentCarEntity) throws NullPointerException {

        var isRent = rentCarRepository.checkRentCarById(rentCarEntity.getCar_id(), rentCarEntity.getDate_from());
        if (isRent.stream().count() == 0) {
            rentCarRepository.save(rentCarEntity);
            return "Sorgunuz Ugurla Gonderildi";
        }
        var lastRentTime = isRent.get((int) isRent.stream().count() - 1);
        return lastRentTime.getDate_to().toString() + " tarixinden sonraki tarixler bosdu";

    }


}
