package com.example.rentcar.service;

import com.example.rentcar.dao.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
}
