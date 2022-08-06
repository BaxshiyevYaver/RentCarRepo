package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutDto {
    private Integer id;
    private String name;
    private String title;
    private String text;
    private String image;
}
