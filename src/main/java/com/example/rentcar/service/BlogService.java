package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.repository.BlogCommentsRepository;
import com.example.rentcar.dao.repository.BlogRepository;
import com.example.rentcar.dao.repository.FileSystemRepository;
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
    public void saveBlog(MultipartFile multipartFile, String title, String article, String text, String author, Integer id) throws IOException {
        BlogDto blogDto = new BlogDto();

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd' AT 'HH:mm").format(Calendar.getInstance().getTime());
        blogDto.setId(id);
        blogDto.setArticle(article);
        blogDto.setAuthor(author);
        blogDto.setDate(timeStamp);
        blogDto.setText(text);
        blogDto.setTitle(title);

        blogDto.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        blogRepository.save(BlogMapper.INSTANCE.mapBlogDtoToEntity(blogDto));

    }


    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public void editSaveBlog(Integer id, MultipartFile multipartFile, String title, String article, String text, String author) throws IOException {
        var blogEntity = blogRepository.findById(id).get();
        var blogDto = BlogMapper.INSTANCE.mapBlogEntityToDto(blogEntity);


        blogDto.setTitle(title);
        blogDto.setArticle(article);
        blogDto.setText(text);
        blogDto.setAuthor(author);
        blogDto.setImage(blogEntity.getImage());

        if (!multipartFile.isEmpty()) {
            blogDto.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        }
        blogRepository.save(BlogMapper.INSTANCE.mapBlogDtoToEntity(blogDto));
    }


}


//    FileSystemRepository fileSys = new FileSystemRepository();
//        fileSys.save(files.getBytes(),files.getOriginalFilename());