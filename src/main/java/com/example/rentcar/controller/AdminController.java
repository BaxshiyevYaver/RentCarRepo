package com.example.rentcar.controller;

import com.example.rentcar.model.*;
import com.example.rentcar.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class AdminController {
    InformationService informationService;
    ContactUsService contactUsService;
    BlogService blogService;
    ServicesService servicesService;
    AboutService aboutService;
    ClientsService clientsService;
    CarsService carsService;
    RankingService rankingService;


    @GetMapping("/admin")
    public String redirectAdminPage(Model model) {
        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);

        List<ContactUsDto> contactUsDtoList = contactUsService.getContactUsList();
        model.addAttribute("contacts", contactUsDtoList);

        List<BlogDto> blogDtoList = blogService.getBlogList();
        model.addAttribute("blogs", blogDtoList);

        List<ServicesDto> servicesDtoList = servicesService.getServicesList();
        model.addAttribute("services", servicesDtoList);

        List<AboutDto> aboutDtoList = aboutService.getAboutList();
        model.addAttribute("about", aboutDtoList);

        List<ClientsDto> clientsDtoList = clientsService.getClientsList();
        model.addAttribute("clients", clientsDtoList);

        List<CarsDto> carsDtoList = carsService.getCarsList();
        model.addAttribute("cars", carsDtoList);

        List<RankingDto> rankingDtoList = rankingService.getRankingList();
        model.addAttribute("rankings", rankingDtoList);
        return "admin";
    }


}
