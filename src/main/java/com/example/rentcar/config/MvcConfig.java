package com.example.rentcar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/services").setViewName("services");
        registry.addViewController("/blog").setViewName("blog");
        registry.addViewController("/car").setViewName("car");
        registry.addViewController("/pricing").setViewName("pricing");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/blog-single").setViewName("blog-single");
        registry.addViewController("/car-single").setViewName("car-single");



    }
}