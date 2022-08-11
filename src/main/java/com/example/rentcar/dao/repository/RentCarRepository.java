package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.RankingEntity;
import com.example.rentcar.dao.entity.RentCarEntity;
//import com.example.rentcar.mapper.CarsMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RentCarRepository extends JpaRepository<RentCarEntity,Integer> {

//    @Query("SELECT c FROM rent_car c WHERE c.date_from between ?1 and ?2")
//    Date checkRentCar(Date date_from, Date date_to);

    @Query("SELECT c FROM rent_car c WHERE  c.car_id = ?1 and c.date_to >= ?2")
    List<RentCarEntity> checkRentCarById(Integer car_id, Date date_from);

}
