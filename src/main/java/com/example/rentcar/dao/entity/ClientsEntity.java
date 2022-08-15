package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "clients")
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "work")
    private String work;
    @Column(name = "about")
    private String about;
    @Lob
    @Column(name = "image")
    private String image;
    @Column(name = "image_name")
    private String image_name;


}
