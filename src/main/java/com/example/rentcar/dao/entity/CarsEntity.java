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
    @Column(name = "price_per_hour")
    private Double price_per_hour;
    @Column(name = "price_per_day")
    private Double price_per_day;
    @Column(name = "price_per_month")
    private Double price_per_month;
    @Column(name = "image")
    private String image;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "seats")
    private Integer seats;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "airconditions")
    private Boolean airconditions;
    @Column(name = "child_seat")
    private Boolean child_seat;
    @Column(name = "gps")
    private Boolean gps;
    @Column(name = "seat_belt")
    private Boolean seat_belt;
    @Column(name = "bluetooth")
    private Boolean bluetooth;
    @Column(name = "onboard_computer")
    private Boolean onboard_computer;
    @Column(name = "audio_input")
    private Boolean audio_input;
    @Column(name = "remote_central_locking")
    private Boolean remote_central_locking;
    @Column(name = "climate_control")
    private Boolean climate_control;
    @Column(name = "description")
    private String description;
    @Column(name = "year")
    private Integer year;
}
