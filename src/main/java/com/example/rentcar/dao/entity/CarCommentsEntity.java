package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "carComments")
@Table(name = "carComments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @Column(name = "image")
    private String image;
    @Column(name = "date")
    private Date text;






}
