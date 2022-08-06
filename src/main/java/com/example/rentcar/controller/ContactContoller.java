package com.example.rentcar.controller;

import com.example.rentcar.model.ContactUsDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.service.ContactUsService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getInformation(Model model) {
        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "contact";
    }

    @PostMapping("/saveContactUs")
    public String saveContactUs(ContactUsDto contactUsDto) {
        contactUsService.saveContactUs(contactUsDto);
        return "redirect:/rentCar/contact/";
    }

    @PostMapping("/saveInformation")
    public String saveInformation(InformationDto informationDto) {
        informationService.saveInformation(informationDto);
        return "redirect:/rentCar/admin/";
    }

    //    @PostMapping("/saveAllinformations")
//    public String saveAllinformations(List<InformationEntity> informations) {
//        informationService.saveAllinformations(informations);
//        return "redirect:/rentCar/admin/";
//    }
    @GetMapping("/deleteInformation/")
    public String deleteLaptop() {
        informationService.deleteInformation();
        return "redirect:/rentCar/admin/";
    }
    @GetMapping("/editInformation/{informationId}")
    public String editInformation(
            @PathVariable("informationId") Integer informationId,
            Model model) {
        InformationDto informationDto = informationService.getnIformation(informationId);
        model.addAttribute("information", informationDto);
        return "edit_information";
    }

    @GetMapping("/deleteAllContactUs/")
    public String deleteAllContactUs() {
        contactUsService.deleteAllContactUs();
        return "redirect:/rentCar/admin/";
    }

    @GetMapping("/deleteContactUs/{contactId}")
    public String deleteContactUs(@PathVariable("contactId") Integer contactId) {
        contactUsService.deleteContactUs(contactId);
        return "redirect:/rentCar/admin/";
    }

}
