package com.example.rentcar.service;

import com.example.rentcar.dao.entity.InformationEntity;
import com.example.rentcar.dao.repository.InformationRepository;
import com.example.rentcar.mapper.InformationMapper;
import com.example.rentcar.model.InformationDto;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformationService {
    InformationRepository informationRepository;

    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }


    public  List<InformationDto> getInformationList() {
        List<InformationEntity> informations = informationRepository.findAll();

        var informationDtoList = informations.stream()
                .map(InformationMapper.INSTANCE::mapInformationEntityToDto)
                .collect(Collectors.toList());

        return informationDtoList;

    }
}
