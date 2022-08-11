package com.example.rentcar.controller;

import com.example.rentcar.dao.entity.AboutEntity;
import com.example.rentcar.model.*;
import com.example.rentcar.service.AboutService;
import com.example.rentcar.service.ClientsService;
import com.example.rentcar.service.InformationService;
import com.example.rentcar.service.RankingService;
import lombok.AllArgsConstructor;
import org.mapstruct.ap.shaded.freemarker.core.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Calendar;
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
    public String saveAbout(AboutDto aboutDto) throws IOException {

//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        aboutDto.setImage(fileName);
//
//        aboutService.saveAbout(aboutDto);
////
//      String uploadDir = "about-photos";
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        aboutService.saveAbout(aboutDto);
        return "redirect:/admin/admin/";
    }

    @GetMapping("/deleteClient/{clientId}")
    public String deleteClient(@PathVariable("clientId") Integer clientId) {
        clientsService.deleteClients(clientId);

        return "redirect:/admin/admin/";
    }

    @GetMapping("/editClient/{clientId}")
    public String editClient(
            @PathVariable("clientId") Integer clientId,
            Model model) {
        ClientsDto clientsDto = clientsService.getClient(clientId);
        model.addAttribute("client", clientsDto);
        return "edit_client";
    }

    @PostMapping("/saveClient")
    public String saveClient(@RequestParam("image") MultipartFile multipartFile,
                             @RequestParam("name") String name,
                             @RequestParam("about") String about,
                             @RequestParam("work") String work,
                             @RequestParam(value = "id", required = false) Integer id) throws IOException {
        clientsService.saveClient(multipartFile, name, about, work, id);
        return "redirect:/admin/admin/";
    }

    @PostMapping("/editSaveClient/{id}")
    public String editSaveClient(@PathVariable Integer id,
                                 @RequestParam("image1") MultipartFile multipartFile,
                                 @RequestParam("name") String name,
                                 @RequestParam("about") String about,
                                 @RequestParam("work") String work
    ) throws IOException{
        clientsService.editSaveClient(id, multipartFile, name, about, work);
        return "redirect:/admin/admin/";
    }
    @PostMapping("/editSaveAbout/{id}")
    public String editSaveCar(@PathVariable Integer id,
                              @RequestParam("image2") MultipartFile multipartFile,
                              AboutDto aboutDto
    ) throws IOException {
        aboutService.editSaveAbout(id, multipartFile, aboutDto);
        return "redirect:/admin/admin/";
    }

    @PostMapping("/saveRanking")
    public String saveRanking(RankingDto rankingDto) {
        rankingService.saveRanking(rankingDto);
        return "redirect:/admin/admin/";
    }
}
