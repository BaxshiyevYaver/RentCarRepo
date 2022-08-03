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
    @Column(name = "pricePerHour")
    private Integer pricePerHour;
    @Column(name = "pricePerDay")
    private Integer pricePerDay;
    @Column(name = "pricePerMonth")
    private Integer pricePerMonth;
    @Column(name = "image")
    private String image;
    @Column(name = "mileage")
    private String mileage;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "seats")
    private String seats;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "airconditions")
    private Boolean airconditions;
    @Column(name = "childSeat")
    private Boolean childSeat;
    @Column(name = "gps")
    private Boolean gps;
    @Column(name = "seatBelt")
    private Boolean seatBelt;
    @Column(name = "bluetooth")
    private Boolean bluetooth;
    @Column(name = "onboardComputer")
    private Boolean onboardComputer;
    @Column(name = "audioInput")
    private Boolean audioInput;
    @Column(name = "remoteCentralLocking")
    private Boolean remoteCentralLocking;
    @Column(name = "climateControl")
    private Boolean climateControl;
    @Column(name = "description")
    private String description;




}
