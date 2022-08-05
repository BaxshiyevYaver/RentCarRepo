package com.example.rentcar.controller;

import com.example.rentcar.model.*;
import com.example.rentcar.service.AboutService;
import com.example.rentcar.service.ClientsService;
import com.example.rentcar.service.InformationService;
import com.example.rentcar.service.RankingService;
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
public class AboutController {
    AboutService aboutService;
    ClientsService clientsService;
    RankingService rankingService;
    InformationService informationService;


    @GetMapping("/about")
    public String getAbout(Model model) {
        List<AboutDto> aboutDtoList = aboutService.getAboutList();
        model.addAttribute("about", aboutDtoList);

        List<ClientsDto> clientsDtoList = clientsService.getClientsList();
        model.addAttribute("clients", clientsDtoList);

        List<RankingDto> rankingDtoList = rankingService.getRankingList();
        model.addAttribute("rankings", rankingDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);

        return "about";
    }
    @GetMapping("/editAbout/{aboutId}")
    public String editAbout(
            @PathVariable("aboutId") Integer aboutId,
            Model model) {
        AboutDto aboutDto = aboutService.getAbout(aboutId);
        model.addAttribute("about", aboutDto);
        return "edit_about";
    }

    @PostMapping("/saveAbout")
    public String saveAbout(AboutDto aboutDto) {
        aboutService.saveAbout(aboutDto);
        return "redirect:/rentCar/admin/";
    }
}
