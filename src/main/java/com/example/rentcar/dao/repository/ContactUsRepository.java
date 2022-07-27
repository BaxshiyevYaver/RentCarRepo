package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.ContactUsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUsEntity, Integer> {
}
