package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.ContactUsEntity;
import com.example.rentcar.dao.entity.ServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<ServicesEntity, Integer> {
}
