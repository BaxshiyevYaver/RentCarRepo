package com.example.rentcar.controller;

import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.service.BlogCommentsService;
import com.example.rentcar.service.BlogService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    InformationService informationService;



    @GetMapping("/blog")
    public String getBlog(Model model) {
        List<BlogDto> blogDtoList = blogService.getBlogList();
        model.addAttribute("blogs", blogDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "blog";
    }


    @GetMapping("/blog-single/{blogId}")
    public String getBlogSingle( @PathVariable("blogId") Integer blogId,
                                 Model model) {
        BlogDto blogDto = blogService.getBlog(blogId);
        model.addAttribute("blog", blogDto);

        List<BlogCommentsDto> blogCommentsDtoList = blogCommentsService.getBlogCommentsList();
        model.addAttribute("blogComments", blogCommentsDtoList);

        List<BlogDto> blogDtoList = blogService.getBlogList();
        model.addAttribute("blogs", blogDtoList);

        List<InformationDto> informationDtoList = informationService.getInformationList();
        model.addAttribute("informations", informationDtoList);
        return "blog-single";
    }

//    @GetMapping("/editInformation/{informationId}")
//    public String editInformation(
//            @PathVariable("informationId") Integer informationId,
//            Model model) {
//        InformationDto informationDto = informationService.getnIformation(informationId);
//        model.addAttribute("information", informationDto);
//        return "edit_information";
//    }

    @PostMapping("/saveBlogComments")
    public String saveBlogComments(BlogCommentsDto blogCommentsDto) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd' AT 'HH:mm").format(Calendar.getInstance().getTime());
        blogCommentsDto.setDate(timeStamp);

        blogCommentsService.saveBlogComments(blogCommentsDto);
        return "redirect:/rentCar/blog-single/";

    }

    @PostMapping("/saveBlog")
    public String saveBlog(BlogDto blogDto) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd' AT 'HH:mm").format(Calendar.getInstance().getTime());
        blogDto.setDate(timeStamp);
        blogService.saveBlog(blogDto);
        return "redirect:/rentCar/admin/";
    }

    @GetMapping("/deleteBlog/{blogId}")
    public String deleteBlog(@PathVariable("blogId") Integer blogId, Model model) {
        blogService.deleteBlog(blogId);

        return "redirect:/rentCar/admin/";
    }

    @GetMapping("/editBlog/{blogId}")
    public String editInformation(
            @PathVariable("blogId") Integer blogId,
            Model model) {
        BlogDto blogDto = blogService.getBlog(blogId);
        model.addAttribute("blog", blogDto);
        return "edit_blog";
    }

}
