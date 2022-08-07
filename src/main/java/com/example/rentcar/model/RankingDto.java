package com.example.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {
    private Integer id;
    private Integer total_branches;
    private Integer start_year;

}
