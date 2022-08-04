package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.repository.BlogCommentsRepository;
import com.example.rentcar.mapper.BlogCommentsMapper;
import com.example.rentcar.mapper.BlogMapper;
import com.example.rentcar.mapper.ContactUsMapper;
import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.ContactUsDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BlogCommentsService {
    BlogCommentsRepository blogCommentsRepository;

    public BlogCommentsService(BlogCommentsRepository blogCommentsRepository) {
        this.blogCommentsRepository = blogCommentsRepository;
    }

    public List<BlogCommentsDto> getBlogCommentsList() {
        List<BlogCommentsEntity> blogComments = blogCommentsRepository.findAll();

        var blogCommentsDtoList = blogComments.stream()
                .map(BlogCommentsMapper.INSTANCE::mapBlogCommentsEntityToDto)
                .collect(Collectors.toList());

        return blogCommentsDtoList;

    }

    public void saveBlogComments(BlogCommentsDto blogCommentsDto) {

        blogCommentsRepository.save(BlogCommentsMapper.INSTANCE.mapBlogCommentsDtoToEntity(blogCommentsDto));


//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        blogCommentsDto.setDate(timeStamp);

    }
}
