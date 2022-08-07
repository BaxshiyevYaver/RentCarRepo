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
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class RankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_branches")
    private Integer total_branches;
    @Column(name = "start_year")
    private Integer start_year;
}
