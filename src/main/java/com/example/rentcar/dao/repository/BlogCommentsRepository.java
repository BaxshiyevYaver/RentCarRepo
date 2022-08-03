package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentsRepository extends JpaRepository<BlogCommentsEntity, Integer> {
}
