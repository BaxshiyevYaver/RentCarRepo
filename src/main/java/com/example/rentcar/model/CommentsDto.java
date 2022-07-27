package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private Integer id;
    private String name;
    private String email;
    private String message;

}