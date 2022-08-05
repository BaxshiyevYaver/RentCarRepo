package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.InformationEntity;
import com.example.rentcar.model.InformationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InformationMapper {
    InformationMapper INSTANCE = Mappers.getMapper(InformationMapper.class);

    InformationDto mapInformationEntityToDto(InformationEntity informationEntity);
    InformationEntity mapInformationDtoToEntity(InformationDto informationDto);
}
