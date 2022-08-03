package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "about")
@Table(name = "about")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Column(name = "image")
    private String image;

}
