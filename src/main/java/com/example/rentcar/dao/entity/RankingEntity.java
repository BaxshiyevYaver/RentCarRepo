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

    @Column(name = "year_experienced")
    private Integer year_experienced;
    @Column(name = "total_branches")
    private Integer total_branches;
    @Column(name = "total_cars")
    private Integer total_cars;
    @Column(name = "happy_customers")
    private Integer happy_customers;
}
