package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.model.BlogDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogMapper {
    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    BlogDto mapBlogEntityToDto(BlogEntity blogEntity);
    @Mapping(target = "image", ignore = true)
    BlogEntity mapBlogDtoToEntity(BlogDto blogDto);
}


