package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "blog_comments")
@Table(name = "blog_comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "message")
    private String message;
    @Column(name = "blog_id")
    private Integer blog_id;
    @Column(name = "date")
    private String date;

}
