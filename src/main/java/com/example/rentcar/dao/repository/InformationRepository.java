package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.AboutEntity;
import com.example.rentcar.dao.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<InformationEntity,Integer> {
}
