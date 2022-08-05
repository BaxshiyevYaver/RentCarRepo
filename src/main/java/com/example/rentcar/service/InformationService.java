package com.example.rentcar.service;

import com.example.rentcar.dao.entity.InformationEntity;
import com.example.rentcar.dao.repository.InformationRepository;
import com.example.rentcar.mapper.ContactUsMapper;
import com.example.rentcar.mapper.InformationMapper;
import com.example.rentcar.model.ContactUsDto;
import com.example.rentcar.model.InformationDto;


import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformationService {
    InformationRepository informationRepository;

    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }


    public List<InformationDto> getInformationList() {
        List<InformationEntity> informations = informationRepository.findAll();

        var informationDtoList = informations.stream()
                .map(InformationMapper.INSTANCE::mapInformationEntityToDto)
                .collect(Collectors.toList());

        return informationDtoList;

    }

    @Transactional
    public void saveInformation(InformationDto informationDto) {

        informationRepository.save(InformationMapper.INSTANCE.mapInformationDtoToEntity(informationDto));

    }

//    @Transactional
//    public List<InformationDto> saveAllinformations(List<InformationEntity> informations) {
////        List<InformationEntity> informations = new ArrayList<>();
//        informationRepository.saveAll(informations);
//
//        var informationDtoList = informations.stream()
//                .map(InformationMapper.INSTANCE::mapInformationEntityToDto)
//                .collect(Collectors.toList());
//
//        return informationDtoList;
//
//    }

    public void deleteInformation() {
        informationRepository.deleteAll();
    }

    public InformationDto getnIformation(Integer id) {
        Optional<InformationEntity> optionalInformationEntity = informationRepository.findById(id);
        var informationEntity = optionalInformationEntity.orElseGet(InformationEntity::new);
        var informationDto = InformationMapper.INSTANCE.mapInformationEntityToDto(informationEntity);
        return informationDto;
    }


}
