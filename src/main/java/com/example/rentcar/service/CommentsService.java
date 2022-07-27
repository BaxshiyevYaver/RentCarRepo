package com.example.rentcar.service;

import com.example.rentcar.dao.repository.CommentsRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
}
