package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.dao.repository.BlogCommentsRepository;
import com.example.rentcar.mapper.BlogCommentsMapper;
import com.example.rentcar.model.BlogCommentsDto;
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

    public void saveBlogComments(BlogCommentsDto blogCommentsDto) {

        blogCommentsRepository.save(BlogCommentsMapper.INSTANCE.mapBlogCommentsDtoToEntity(blogCommentsDto));

//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        blogCommentsDto.setDate(timeStamp);

    }
}
