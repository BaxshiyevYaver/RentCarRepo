package com.example.rentcar.controller;

import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.ContactUsDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.service.BlogCommentsService;
import com.example.rentcar.service.BlogService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class BlogController {
    BlogService blogService;
    BlogCommentsService blogCommentsService;


    @GetMapping("/blog")
    public String getBlog(Model model) {
        List<BlogDto> blogDtoList = blogService.getBlogList();
        model.addAttribute("blogs", blogDtoList);
        return "blog";
    }


    @GetMapping("/blog-single")
    public String getBlogSingle(Model model) {
        List<BlogDto> blogDtoList = blogService.getBlogList();
        List<BlogCommentsDto> blogCommentsDtoList = blogCommentsService.getBlogCommentsList();
        model.addAttribute("blogComments", blogCommentsDtoList);

        model.addAttribute("blogs", blogDtoList);

        return "blog-single";
    }

    @PostMapping("/saveBlogComments")
    public String saveBlogComments(BlogCommentsDto blogCommentsDto) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd' AT 'HH:mm").format(Calendar.getInstance().getTime());
        blogCommentsDto.setDate(timeStamp);

        blogCommentsService.saveBlogComments(blogCommentsDto);
        return "redirect:/rentCar/blog-single/";

    }

}
