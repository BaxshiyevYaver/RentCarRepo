package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDto {
    private Integer id;
    private String name;
    private String mark;
    private Double price_per_hour;
    private Double price_per_day;
    private Double price_per_month;
    private String image;
    private Integer mileage;
    private String transmission;
    private Integer seats;
    private String fuel;
    private Boolean airconditions;
    private Boolean child_seat;
    private Boolean gps;
    private Boolean seat_belt;
    private Boolean bluetooth;
    private Boolean onboard_computer;
    private Boolean audio_input;
    private Boolean remote_central_locking;
    private Boolean climate_control;
    private String description;
    private Integer year;

}
