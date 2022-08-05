
package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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


