package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.repository.BlogCommentsRepository;
import com.example.rentcar.mapper.BlogCommentsMapper;
import com.example.rentcar.mapper.BlogMapper;
import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.BlogDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

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


}
