package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.dao.entity.CarCommentsEntity;
import com.example.rentcar.dao.repository.CarCommentsRepository;
import com.example.rentcar.mapper.BlogCommentsMapper;
import com.example.rentcar.mapper.CarCommentsMapper;
import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.CarCommentsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarCommentsService {
    CarCommentsRepository carCommentsRepository;

    public CarCommentsService(CarCommentsRepository carCommentsRepository) {
        this.carCommentsRepository = carCommentsRepository;
    }

    public List<CarCommentsDto> getCarCommentsList() {
        List<CarCommentsEntity> carComments = carCommentsRepository.findAll();

        var carCommentsDtoList = carComments.stream()
                .map(CarCommentsMapper.INSTANCE::mapCarCommentsEntityToDto)
                .collect(Collectors.toList());
        return carCommentsDtoList;
    }

    public void saveCarComments(CarCommentsDto carCommentsDto) {

        carCommentsRepository.save(CarCommentsMapper.INSTANCE.mapCarCommentsDtoToEntity(carCommentsDto));
    }
}
