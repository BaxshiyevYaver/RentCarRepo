package com.example.rentcar.service;

import com.example.rentcar.dao.repository.ContactUsRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {
    ContactUsRepository contactUsRepository;

    public ContactUsService(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }
}
