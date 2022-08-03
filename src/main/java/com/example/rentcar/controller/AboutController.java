package com.example.rentcar.controller;

import com.example.rentcar.model.AboutDto;
import com.example.rentcar.model.ServicesDto;
import com.example.rentcar.service.AboutService;
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

    @GetMapping("/about")
    public String getAbout(Model model) {
        List<AboutDto> aboutDtoListDtoList = aboutService.getAboutList();
        model.addAttribute("about", aboutDtoListDtoList);
        return "about";
    }
}
