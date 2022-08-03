package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCommentsDto {
    private Integer id;
    private String name;
    private String email;
    private String message;
//    private Date date;
//    private Time time;

}
