package com.example.rentcar.controller;

import com.example.rentcar.model.InformationDto;
import com.example.rentcar.model.ServicesDto;
import com.example.rentcar.service.InformationService;
import com.example.rentcar.service.ServicesService;
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
public class ServicesController {
    ServicesService servicesService;
    InformationService informationService;


    @GetMapping("/services")
    public String getServices(Model model) {
        List<ServicesDto> servicesDtoList = servicesService.getServicesList();
        model.addAttribute("services", servicesDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "services";
    }

    @GetMapping("/deleteService/{serviceId}")
    public String deleteService(@PathVariable("serviceId") Integer serviceId) {
        servicesService.deleteService(serviceId);

        return "redirect:/admin/admin/";
    }

    @GetMapping("/editService/{serviceId}")
    public String editService(
            @PathVariable("serviceId") Integer serviceId,
            Model model) {
        ServicesDto servicesDto = servicesService.getService(serviceId);
        model.addAttribute("service", servicesDto);
        return "edit_service";
    }

    @PostMapping("/saveService")
    public String saveService(ServicesDto servicesDto) {
        servicesService.saveService(servicesDto);
        return "redirect:/admin/admin/";
    }
}
