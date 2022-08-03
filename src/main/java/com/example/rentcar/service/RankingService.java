package com.example.rentcar.service;

import com.example.rentcar.dao.repository.RankingRepository;
import org.springframework.stereotype.Service;

@Service

public class RankingService {
    RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }
}
