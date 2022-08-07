package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity,Integer> {

}
