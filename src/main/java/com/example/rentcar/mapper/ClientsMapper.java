package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.CarsEntity;
import com.example.rentcar.dao.entity.ClientsEntity;
import com.example.rentcar.model.CarsDto;
import com.example.rentcar.model.ClientsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientsMapper {
    ClientsMapper INSTANCE = Mappers.getMapper(ClientsMapper.class);

    ClientsDto mapPersonEntityToDto(ClientsEntity clientsEntity);
    ClientsEntity mapPersonDtoToEntity(ClientsDto clientsDto);
}
