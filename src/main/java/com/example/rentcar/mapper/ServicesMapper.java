package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.ContactUsEntity;
import com.example.rentcar.dao.entity.ServicesEntity;
import com.example.rentcar.model.ContactUsDto;
import com.example.rentcar.model.ServicesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServicesMapper {
    ServicesMapper INSTANCE = Mappers.getMapper(ServicesMapper.class);

    ServicesDto mapServicesEntityToDto(ServicesEntity servicesEntity);
    ServicesEntity mapServicesDtoToEntity(ServicesDto servicesDto);
}
