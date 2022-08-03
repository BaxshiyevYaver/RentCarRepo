package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity(name = "blogComments")
@Table(name = "blogComments")
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
//    @Column(name = "date")
//    private Date date;
//    @Column(name = "time")
//    private Time time;
}
