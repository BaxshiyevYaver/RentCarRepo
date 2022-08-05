package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCommentsDto {
    private Integer id;
    private String name;
    private String text;
    private Date date;
    private Integer car_id;

}
