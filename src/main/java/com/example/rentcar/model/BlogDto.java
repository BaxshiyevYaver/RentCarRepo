package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private Integer id;
    private String title;
    private String text;
    private Date date;
    private String author;
    private String image;
}
