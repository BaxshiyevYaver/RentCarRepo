package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.repository.BlogCommentsRepository;
import com.example.rentcar.mapper.BlogCommentsMapper;
import com.example.rentcar.mapper.BlogMapper;
import com.example.rentcar.model.BlogCommentsDto;
import com.example.rentcar.model.BlogDto;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class BlogCommentsService {
    BlogCommentsRepository blogCommentsRepository;

    public BlogCommentsService(BlogCommentsRepository blogCommentsRepository) {
        this.blogCommentsRepository = blogCommentsRepository;
    }

    public List<BlogCommentsDto> getBlogCommentsList(Integer blogId) {
        List<BlogCommentsEntity> blogComments = blogCommentsRepository.findbyBlogID(blogId);

        var blogCommentsDtoList = blogComments.stream()
                .map(BlogCommentsMapper.INSTANCE::mapBlogCommentsEntityToDto)
                .collect(Collectors.toList());

        return blogCommentsDtoList;
    }

    public void deleteBlogComments() {
        blogCommentsRepository.deleteAll();
        int a=1;
    }

    public void saveBlogComments(BlogCommentsDto blogCommentsDto) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd' AT 'HH:mm").format(Calendar.getInstance().getTime());
        blogCommentsDto.setDate(timeStamp);
        blogCommentsRepository.save(BlogCommentsMapper.INSTANCE.mapBlogCommentsDtoToEntity(blogCommentsDto));
    }
//    public BlogCommentsDto findbyBlogID(Integer id) {
//        Optional<BlogCommentsEntity> optionalBlogCommentsEntity = blogCommentsRepository.findbyBlogID(id);
//        var blogCommentsEntity = optionalBlogCommentsEntity.orElseGet(BlogCommentsEntity::new);
//        var blogCommentsDto = BlogCommentsMapper.INSTANCE.mapBlogCommentsEntityToDto(blogCommentsEntity);
//        return blogCommentsDto;
//    }

   // public int totalcomments() {
//        return blogCommentsRepository.totalComments();
//    }

}
