package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDto {
    private Integer id;
    private String name;
    private String mark;
    private Integer price;
    private String image;
}
