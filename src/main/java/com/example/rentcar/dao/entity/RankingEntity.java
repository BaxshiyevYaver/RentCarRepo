package com.example.rentcar.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ranking")
@Table(name = "ranking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "yearExperienced")
    private Integer yearExperienced;
    @Column(name = "totalBranches")
    private Integer totalBranches;
    @Column(name = "totalCars")
    private Integer totalCars;
    @Column(name = "happyCustomers")
    private Integer happyCustomers;
}
