package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.model.BlogCommentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogCommentsMapper {
    BlogCommentsMapper INSTANCE = Mappers.getMapper(BlogCommentsMapper.class);

    @Mapping(source = "blogEntity.id", target = "blog_id")
    BlogCommentsDto mapBlogCommentsEntityToDto(BlogCommentsEntity blogcCommentsEntity);

    @Mapping(source = "blog_id", target = "blogEntity.id")
    BlogCommentsEntity mapBlogCommentsDtoToEntity(BlogCommentsDto blogCommentsDto);


}
