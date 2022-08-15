package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.CarCommentsEntity;
import com.example.rentcar.dao.entity.RentCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CarCommentsRepository extends JpaRepository<CarCommentsEntity, Integer> {
    @Query("select c FROM car_comments c  WHERE  c.car_id = ?1")
    Iterable<CarCommentsEntity> checkComments(Integer id);
}
