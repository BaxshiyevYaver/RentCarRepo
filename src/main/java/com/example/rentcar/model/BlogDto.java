
package com.example.rentcar.model;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private Integer id;
    private String article;
    private String title;
    private String text;
    private String date;
    private String author;
    private String image;
}


