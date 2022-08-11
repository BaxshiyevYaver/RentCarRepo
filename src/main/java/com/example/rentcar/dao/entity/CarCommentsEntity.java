package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "car_comments")
@Table(name = "car_comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CarCommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private Date date;
    @Column(name = "car_id")
    private Integer car_id;


}
