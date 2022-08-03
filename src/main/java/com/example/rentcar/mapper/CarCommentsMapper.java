package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.CarCommentsEntity;
import com.example.rentcar.model.CarCommentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarCommentsMapper {
    CarCommentsMapper INSTANCE = Mappers.getMapper(CarCommentsMapper.class);

    CarCommentsDto mapCarCommentsEntityToDto(CarCommentsEntity carCommentsEntity);
    CarCommentsEntity mapCarCommentsDtoToEntity(CarCommentsDto carCommentsDto);
}
