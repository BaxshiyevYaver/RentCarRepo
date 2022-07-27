package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.entity.CarsEntity;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.CarsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogMapper {
    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    BlogDto mapPersonEntityToDto(BlogEntity blogEntity);

    BlogEntity mapPersonDtoToEntity(BlogEntity blogEntity);
}
