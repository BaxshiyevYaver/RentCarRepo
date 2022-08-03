package com.example.rentcar.controller;

import com.example.rentcar.model.ContactUsDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.service.ContactUsService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class ContactContoller {
    ContactUsService contactUsService;
    InformationService informationService;

    @GetMapping("/contact")
    public String getContact(Model model) {
        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "contact";
    }

    @PostMapping("/saveContactUs")
    public String saveContactUs(ContactUsDto contactUsDto) {
        contactUsService.saveContactUs(contactUsDto);
        return "redirect:/rentCar/contact/";
    }
}
