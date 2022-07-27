package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.ClientsEntity;
import com.example.rentcar.dao.entity.CommentsEntity;
import com.example.rentcar.model.ClientsDto;
import com.example.rentcar.model.CommentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentsMapper {
    CommentsMapper INSTANCE = Mappers.getMapper(CommentsMapper.class);

    CommentsDto mapPersonEntityToDto(CommentsEntity commentsEntity);
    CommentsEntity mapPersonDtoToEntity(CommentsDto commentsDto);
}
