package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.CarsEntity;
import com.example.rentcar.dao.entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository  extends JpaRepository<ClientsEntity, Integer> {
}
