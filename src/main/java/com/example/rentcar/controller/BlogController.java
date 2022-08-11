package com.example.rentcar.controller;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.InformationDto;
import com.example.rentcar.service.BlogCommentsService;
import com.example.rentcar.service.BlogService;
import com.example.rentcar.service.InformationService;
import lombok.AllArgsConstructor;
import org.mapstruct.ap.shaded.freemarker.core.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/rentCar")
@AllArgsConstructor
public class BlogController {
    @Autowired

    BlogService blogService;
    @Autowired
    BlogCommentsService blogCommentsService;
    @Autowired

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
    public String getBlogSingle(@PathVariable("blogId") Integer blogId,
                                Model model) {
        BlogDto blogDto = blogService.getBlog(blogId);
        model.addAttribute("blog", blogDto);

        List<BlogCommentsDto> blogCommentsDtoList = blogCommentsService.getBlogCommentsList(blogId);
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


        blogCommentsService.saveBlogComments(blogCommentsDto);

        return "redirect:/rentCar/blog/";

    }

    @PostMapping("/saveBlog")
    public String saveBlog(@RequestParam("blogImage") MultipartFile multipartFile,
                           @RequestParam("title") String title,
                           @RequestParam("article") String article,
                           @RequestParam("text") String text,
                           @RequestParam("author") String author,
                           @RequestParam(value = "id", required = false) Integer id) throws IOException {


        blogService.saveBlog(multipartFile, title, article, text, author, id);
        return "redirect:/admin/admin/";
    }

    @PostMapping("/editSaveBlog/{id}")
    public String editSaveBlog(@PathVariable Integer id,
                               @RequestParam("image1") MultipartFile multipartFile,
                               @RequestParam("title") String title,
                               @RequestParam("article") String article,
                               @RequestParam("text") String text,
                               @RequestParam("author") String author
    ) throws IOException {
        blogService.editSaveBlog(id, multipartFile, title, article, text, author);
        return "redirect:/admin/admin/";
    }

    @GetMapping("/deleteBlog/{blogId}")
    public String deleteBlog(@PathVariable("blogId") Integer blogId) {

        blogCommentsService.deleteBlogComments();
        blogService.deleteBlog(blogId);

        return "redirect:/admin/admin/";
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
