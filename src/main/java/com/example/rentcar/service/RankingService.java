package com.example.rentcar.service;

import com.example.rentcar.dao.entity.BlogEntity;
import com.example.rentcar.dao.entity.RankingEntity;
import com.example.rentcar.dao.repository.RankingRepository;
import com.example.rentcar.mapper.RankingMapper;
import com.example.rentcar.model.BlogDto;
import com.example.rentcar.model.RankingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService {
    RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public List<RankingDto> getRankingList() {
        List<RankingEntity> ranking = rankingRepository.findAll();

        var rankingDtoList = ranking.stream()
                .map(RankingMapper.INSTANCE::mapRankingEntityToDto)
                .collect(Collectors.toList());

        return rankingDtoList;

    }


}
