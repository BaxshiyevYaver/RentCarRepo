package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cars")
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "mark")
    private String mark;
    @Column(name = "price")
    private Integer price;
    @Column(name = "image")
    private String image;



}
