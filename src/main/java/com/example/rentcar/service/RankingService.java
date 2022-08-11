package com.example.rentcar.service;

import com.example.rentcar.dao.entity.RankingEntity;
import com.example.rentcar.dao.repository.CarCommentsRepository;
//import com.example.rentcar.dao.repository.CarsRepository;
import com.example.rentcar.dao.repository.RankingRepository;
import com.example.rentcar.mapper.RankingMapper;
import com.example.rentcar.model.RankingDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("rankingService")
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

//        RankingDto rankingDto;
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        rankingDto.setYear_experienced(year - rankingDto.getStart_year());
//        rankingDtoList.set(1,Integer start_year);
////
        return rankingDtoList;
    }

    public RankingDto getRanking(Integer id) {
        Optional<RankingEntity> optionalRankingEntity = rankingRepository.findById(id);
        var rankingEntity = optionalRankingEntity.orElseGet(RankingEntity::new);
        var rankingDto = RankingMapper.INSTANCE.mapRankingEntityToDto(rankingEntity);
        return rankingDto;
    }

    public int calculateExpierence(RankingDto dto){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year-dto.getStart_year();
    }

//dto.setTotal_cars(carsRepository.findAll().stream().count())

    @Transactional
    public void saveRanking(RankingDto rankingDto) {

        rankingRepository.save(RankingMapper.INSTANCE.mapRankingDtoToEntity(rankingDto));

    }
}
