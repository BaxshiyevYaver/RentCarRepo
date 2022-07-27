package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<CarsEntity, Integer> {
}
