package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.entity.ServicesEntity;
import com.example.rentcar.dao.repository.ServicesRepository;
import com.example.rentcar.mapper.BlogMapper;
import com.example.rentcar.mapper.ServicesMapper;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.ServicesDto;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
