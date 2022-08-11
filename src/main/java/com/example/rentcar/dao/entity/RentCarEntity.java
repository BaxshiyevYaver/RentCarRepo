package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "rent_car")
@Table(name = "rent_car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_from")
    private Date date_from;
    @Column(name = "date_to")
    private Date date_to;
    @Column(name = "car_id")
    private Integer car_id;

}
