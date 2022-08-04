package com.example.rentcar.controller;

import com.example.rentcar.model.AboutDto;
import com.example.rentcar.model.ClientsDto;
import com.example.rentcar.model.RankingDto;
import com.example.rentcar.service.AboutService;
import com.example.rentcar.service.ClientsService;
import com.example.rentcar.service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class AboutController {
    AboutService aboutService;
    ClientsService clientsService;
    RankingService rankingService;

    @GetMapping("/about")
    public String getAbout(Model model) {
        List<AboutDto> aboutDtoList = aboutService.getAboutList();
        model.addAttribute("about", aboutDtoList);

        List<ClientsDto> clientsDtoList = clientsService.getClientsList();
        model.addAttribute("clients", clientsDtoList);

        List<RankingDto> rankingDtoList = rankingService.getRankingList();
        model.addAttribute("rankings", rankingDtoList);

        return "about";
    }


}
