package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.entity.ServicesEntity;
import com.example.rentcar.dao.repository.ServicesRepository;
import com.example.rentcar.mapper.BlogMapper;
import com.example.rentcar.mapper.InformationMapper;
import com.example.rentcar.mapper.ServicesMapper;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.model.ServicesDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicesService {
    ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }


    public List<ServicesDto> getServicesList() {
        List<ServicesEntity> services = servicesRepository.findAll();

        var servicesDtoList = services.stream()
                .map(ServicesMapper.INSTANCE::mapServicesEntityToDto)
                .collect(Collectors.toList());

        return servicesDtoList;

    }

    public void deleteService(Integer id) {
        servicesRepository.deleteById(id);
    }

    public ServicesDto getService(Integer id) {
        Optional<ServicesEntity> optionalServicesEntity = servicesRepository.findById(id);
        var servicesEntity = optionalServicesEntity.orElseGet(ServicesEntity::new);
        var servicesDto = ServicesMapper.INSTANCE.mapServicesEntityToDto(servicesEntity);
        return servicesDto;
    }

    @Transactional
    public void saveService(ServicesDto servicesDto) {

        servicesRepository.save(ServicesMapper.INSTANCE.mapServicesDtoToEntity(servicesDto));

    }
}
