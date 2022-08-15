package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsDto {
    private Integer id;
    private String name;
    private String work;
    private String about;
    private String image;
    private String image_name;
}
