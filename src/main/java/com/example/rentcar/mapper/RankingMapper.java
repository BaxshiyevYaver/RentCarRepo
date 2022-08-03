package com.example.rentcar.mapper;

import com.example.rentcar.dao.entity.RankingEntity;
import com.example.rentcar.dao.entity.ServicesEntity;
import com.example.rentcar.model.RankingDto;
import com.example.rentcar.model.ServicesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface RankingMapper {
    RankingMapper INSTANCE = Mappers.getMapper(RankingMapper.class);

    RankingDto mapRankingEntityToDto(RankingEntity rankingEntity);
    RankingEntity mapRankingDtoToEntity(RankingDto rankingDto);
}
