package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDto {
    private Integer id;
    private String name;
    private String mark;
    private Integer pricePerHour;
    private Integer pricePerDay;
    private Integer pricePerMonth;
    private String image;
    private String mileage;
    private String transmission;
    private String seats;
    private String fuel;
    private Boolean airconditions;
    private Boolean childSeat;
    private Boolean gps;
    private Boolean seatBelt;
    private Boolean bluetooth;
    private Boolean onboardComputer;
    private Boolean audioInput;
    private Boolean remoteCentralLocking;
    private Boolean climateControl;
}
