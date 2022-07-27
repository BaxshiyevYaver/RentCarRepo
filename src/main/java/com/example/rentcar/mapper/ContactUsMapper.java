package com.example.rentcar.mapper;


import com.example.rentcar.dao.entity.ContactUsEntity;
import com.example.rentcar.model.ContactUsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactUsMapper {
    ContactUsMapper INSTANCE = Mappers.getMapper(ContactUsMapper.class);

    ContactUsDto mapPersonEntityToDto(ContactUsEntity contactUsEntity);
    ContactUsEntity mapPersonDtoToEntity(ContactUsDto contactUsDto);

}
