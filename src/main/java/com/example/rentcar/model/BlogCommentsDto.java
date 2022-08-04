package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCommentsDto {
    private Integer id;
    private String name;
    private String email;
    private String message;
    private Integer blog_id;
    private String date;

}
