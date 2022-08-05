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
public class WebController {
    AboutService aboutService;
    ClientsService clientsService;
    RankingService rankingService;
    ServicesService servicesService;
    BlogService blogService;
    CarsService carsService;
    InformationService informationService;




    @GetMapping("/home")
    public String redirectIndex(Model model) {
        List<AboutDto> aboutDtoList = aboutService.getAboutList();
        model.addAttribute("about", aboutDtoList);

        List<ClientsDto> clientsDtoList = clientsService.getClientsList();
        model.addAttribute("clients", clientsDtoList);

        List<RankingDto> rankingDtoList = rankingService.getRankingList();
        model.addAttribute("rankings", rankingDtoList);

        List<ServicesDto> servicesDtoList = servicesService.getServicesList();
        model.addAttribute("services", servicesDtoList);

        List<CarsDto> carsDtoList = carsService.getCarsList();
        model.addAttribute("cars", carsDtoList);

        List<BlogDto> blogDtoList = blogService.getBlogList();
        model.addAttribute("blogs", blogDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "index";
    }


}
