package com.example.rentcar.service;

import com.example.rentcar.dao.entity.ContactUsEntity;
import com.example.rentcar.dao.entity.InformationEntity;
import com.example.rentcar.dao.repository.ContactUsRepository;
import com.example.rentcar.mapper.ContactUsMapper;
import com.example.rentcar.mapper.InformationMapper;
import com.example.rentcar.model.ContactUsDto;
import com.example.rentcar.model.InformationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactUsService {
    ContactUsRepository contactUsRepository;

    public ContactUsService(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }

    public List<ContactUsDto> getContactUsList() {
        List<ContactUsEntity> contactUs = contactUsRepository.findAll();

        var contactUSDtoList = contactUs.stream()
                .map(ContactUsMapper.INSTANCE::mapContactUsEntityToDto)
                .collect(Collectors.toList());

        return contactUSDtoList;

    }

    public void saveContactUs(ContactUsDto contactUsDto) {

        contactUsRepository.save(ContactUsMapper.INSTANCE.mapContactUsDtoToEntity(contactUsDto));

    }
    public void deleteContactUs(Integer id) {
        contactUsRepository.deleteById(id);
    }
    public void deleteAllContactUs() {
        contactUsRepository.deleteAll();
    }
}
