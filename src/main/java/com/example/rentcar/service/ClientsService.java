package com.example.rentcar.service;

import com.example.rentcar.dao.entity.ClientsEntity;
import com.example.rentcar.dao.repository.ClientsRepository;
//import com.example.rentcar.mapper.CarsMapper;
import com.example.rentcar.mapper.CarsMapper;
import com.example.rentcar.mapper.ClientsMapper;
import com.example.rentcar.model.CarsDto;
import com.example.rentcar.model.ClientsDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("clientsService")
public class ClientsService {
    ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<ClientsDto> getClientsList() {

        return clientsRepository.findAll()
                .stream()
                .map(ClientsMapper.INSTANCE::mapClientsMapperEntityToDto)
                .collect(Collectors.toList());


    }

//    public String imageName(ClientsEntity clientsEntity) {
//        clientsEntity.getImage().
//        return
//    }

    public long totalClients() {

        return clientsRepository.count();
    }

    public void deleteClients(Integer id) {
        clientsRepository.deleteById(id);
    }

    public ClientsDto getClient(Integer id) {
        Optional<ClientsEntity> optionalClientsEntity = clientsRepository.findById(id);
        var clientsEntity = optionalClientsEntity.orElseGet(ClientsEntity::new);
        var clientsDto = ClientsMapper.INSTANCE.mapClientsMapperEntityToDto(clientsEntity);
        return clientsDto;
    }

    @Transactional
    public void saveClient(ClientsDto clientsDto,MultipartFile image) throws IOException {

        clientsDto.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        clientsDto.setImage_name(image.getOriginalFilename());

        clientsRepository.save(ClientsMapper.INSTANCE.mapClientsMapperDtoToEntity(clientsDto));
    }

    @Transactional
    public void editSaveClient(Integer id, MultipartFile multipartFile,ClientsDto clientsDto) throws IOException {

        var clientsEntity = clientsRepository.findById(id).get();
        var clientsDto1 = ClientsMapper.INSTANCE.mapClientsMapperEntityToDto(clientsEntity);

        clientsDto1.setName(clientsDto.getName());
        clientsDto1.setAbout(clientsDto.getAbout());
        clientsDto1.setWork(clientsDto.getWork());
        if (!multipartFile.isEmpty()) {
            clientsDto1.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
            clientsDto1.setImage_name(multipartFile.getOriginalFilename());
        }
        clientsRepository.save(ClientsMapper.INSTANCE.mapClientsMapperDtoToEntity(clientsDto1));
    }


}
