package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.AboutEntity;
import com.example.rentcar.model.AboutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AboutMapper {
    AboutMapper INSTANCE = Mappers.getMapper(AboutMapper.class);

    AboutDto mapAboutEntityToDto(AboutEntity aboutEntity);
    AboutEntity mapAboutDtoToEntity(AboutDto aboutDto);
}
