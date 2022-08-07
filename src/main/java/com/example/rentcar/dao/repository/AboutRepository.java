package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.AboutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<AboutEntity,Integer> {

}
