package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.CarsEntity;
import com.example.rentcar.dao.entity.ContactUsEntity;
import com.example.rentcar.model.CarsDto;
import com.example.rentcar.model.ContactUsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarsMapper  {
    CarsMapper INSTANCE = Mappers.getMapper(CarsMapper.class);

    CarsDto mapPersonEntityToDto(CarsEntity carsEntity);
    CarsEntity mapPersonDtoToEntity(CarsDto carsDto);
}
