package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.repository.BlogRepository;
import com.example.rentcar.mapper.BlogMapper;
import com.example.rentcar.model.BlogDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogDto> getBlogList() {
        List<BlogEntity> blogs = blogRepository.findAll();

        var blogDtoList = blogs.stream()
                .map(BlogMapper.INSTANCE::mapBlogEntityToDto)
                .collect(Collectors.toList());

        return blogDtoList;

    }
}

