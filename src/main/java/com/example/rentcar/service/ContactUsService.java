package com.example.rentcar.service;

import com.example.rentcar.dao.repository.ContactUsRepository;
import com.example.rentcar.mapper.ContactUsMapper;
import com.example.rentcar.model.ContactUsDto;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {
    ContactUsRepository contactUsRepository;

    public ContactUsService(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }

    public void saveContactUs(ContactUsDto contactUsDto) {

        contactUsRepository.save(ContactUsMapper.INSTANCE.mapContactUsDtoToEntity(contactUsDto));

    }


}
