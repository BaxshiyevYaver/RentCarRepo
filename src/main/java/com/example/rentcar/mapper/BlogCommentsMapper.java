package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.model.BlogCommentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogCommentsMapper {
    BlogCommentsMapper INSTANCE = Mappers.getMapper(BlogCommentsMapper.class);

    BlogCommentsDto mapBlogCommentsEntityToDto(BlogCommentsEntity blogcCommentsEntity);
    BlogCommentsEntity mapBlogCommentsDtoToEntity(BlogCommentsDto blogCommentsDto);
}
