package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "blog")
@Table(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "article")
    private String article;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String date;

    @Column(name = "author")
    private String author;

    @Column(name = "image")
    private String image;


}
