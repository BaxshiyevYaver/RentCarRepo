package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.ClientsEntity;
import com.example.rentcar.model.ClientsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientsMapper {
    ClientsMapper INSTANCE = Mappers.getMapper(ClientsMapper.class);

    ClientsDto mapClientsMapperEntityToDto(ClientsEntity clientsEntity);
    ClientsEntity mapClientsMapperDtoToEntity(ClientsDto clientsDto);
}
