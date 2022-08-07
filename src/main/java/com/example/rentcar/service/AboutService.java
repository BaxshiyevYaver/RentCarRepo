package com.example.rentcar.service;

import com.example.rentcar.dao.entity.AboutEntity;

import com.example.rentcar.dao.repository.AboutRepository;
import com.example.rentcar.mapper.AboutMapper;
import com.example.rentcar.model.AboutDto;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTML;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.swing.text.html.HTML.Tag.S;

@Service
public class AboutService {
    AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public List<AboutDto> getAboutList() {
        List<AboutEntity> abouts = aboutRepository.findAll();

        var aboutDtoList = abouts.stream()
                .map(AboutMapper.INSTANCE::mapAboutEntityToDto)
                .collect(Collectors.toList());

        return aboutDtoList;

    }

    public AboutDto getAbout(Integer id) {
        Optional<AboutEntity> optionalAboutEntity = aboutRepository.findById(id);
        var aboutEntity = optionalAboutEntity.orElseGet(AboutEntity::new);
        var aboutDto = AboutMapper.INSTANCE.mapAboutEntityToDto(aboutEntity);
        return aboutDto;
    }

    @Transactional
    public void saveAbout(AboutDto aboutDto) {

        aboutRepository.save(AboutMapper.INSTANCE.mapAboutDtoToEntity(aboutDto));

    }

}
