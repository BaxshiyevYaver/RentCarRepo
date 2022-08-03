package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {
    private Integer yearExperienced;
    private Integer totalBranches;
    private Integer totalCars;
    private Integer happyCustomers;
}
