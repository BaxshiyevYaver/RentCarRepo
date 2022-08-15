package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.repository.BlogCommentsRepository;
import com.example.rentcar.dao.repository.BlogRepository;
import com.example.rentcar.mapper.BlogMapper;
import com.example.rentcar.mapper.ClientsMapper;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.ClientsDto;
import ognl.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {
    BlogRepository blogRepository;
    BlogCommentsRepository blogCommentsRepository;

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

    public BlogDto getBlog(Integer id) {
        Optional<BlogEntity> optionalBlogEntity = blogRepository.findById(id);
        var blogEntity = optionalBlogEntity.orElseGet(BlogEntity::new);
        var blogDto = BlogMapper.INSTANCE.mapBlogEntityToDto(blogEntity);
        return blogDto;
    }

    @Transactional
    public void saveBlog(MultipartFile blog_image, BlogDto blogDto) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd' AT 'HH:mm").format(Calendar.getInstance().getTime());
        blogDto.setDate(timeStamp);

        blogDto.setImage(Base64.getEncoder().encodeToString(blog_image.getBytes()));
        blogRepository.save(BlogMapper.INSTANCE.mapBlogDtoToEntity(blogDto));

    }


    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public void editSaveBlog(Integer id, MultipartFile blog_image, BlogDto blogDto) throws IOException {
        var blogEntity = blogRepository.findById(id).get();
        var blogDtoOld = BlogMapper.INSTANCE.mapBlogEntityToDto(blogEntity);

        if (blog_image.isEmpty()) {
            blogDto.setImage(blogDtoOld.getImage());
        } else {
            blogDto.setImage(Base64.getEncoder().encodeToString(blog_image.getBytes()));
        }
        blogRepository.save(BlogMapper.INSTANCE.mapBlogDtoToEntity(blogDto));
    }


}

