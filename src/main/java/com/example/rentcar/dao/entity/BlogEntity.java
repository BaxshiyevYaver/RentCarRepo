package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "blog")
@Table(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Lob
    @Column(name = "image")
    private String image;

    @OneToMany(cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    private Set<BlogCommentsEntity> orderDetail = new HashSet();

//(fetch = FetchType.EAGER)
}
//    private List<BlogCommentsEntity> blogCommentsEntities;
