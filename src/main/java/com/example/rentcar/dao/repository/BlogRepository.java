package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Integer> {

}
