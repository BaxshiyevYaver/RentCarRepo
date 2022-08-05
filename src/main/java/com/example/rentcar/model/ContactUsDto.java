package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsDto {
    private Integer id;
    private String name;
    private String email;
    private String subject;
    private String message;
}
