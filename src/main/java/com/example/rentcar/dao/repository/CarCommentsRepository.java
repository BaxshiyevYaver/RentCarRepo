package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.CarCommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCommentsRepository extends JpaRepository<CarCommentsEntity, Integer> {
}