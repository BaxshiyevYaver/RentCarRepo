package com.example.rentcar.service;

import com.example.rentcar.dao.entity.ClientsEntity;
import com.example.rentcar.dao.repository.ClientsRepository;
//import com.example.rentcar.mapper.CarsMapper;
import com.example.rentcar.mapper.ClientsMapper;
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
    public void saveClient(MultipartFile multipartFile, String name, String about, String work, Integer id) throws IOException {

        ClientsDto clientsDto = new ClientsDto();
        clientsDto.setId(id);
        clientsDto.setName(name);
        clientsDto.setAbout(about);
        clientsDto.setWork(work);
        clientsDto.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        clientsRepository.save(ClientsMapper.INSTANCE.mapClientsMapperDtoToEntity(clientsDto));
    }

    @Transactional
    public void editSaveClient(Integer id, MultipartFile multipartFile, String name, String about, String work) throws IOException {

        var clientsEntity=clientsRepository.findById(id).get();
        var clientsDto= ClientsMapper.INSTANCE.mapClientsMapperEntityToDto(clientsEntity);


        clientsDto.setName(name);
        clientsDto.setAbout(about);
        clientsDto.setWork(work);
        if (!multipartFile.isEmpty()) {
            clientsDto.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        }
        clientsRepository.save(ClientsMapper.INSTANCE.mapClientsMapperDtoToEntity(clientsDto));
    }


}
//        ClientsDto clien1 = new ClientsDto(cl);

//        var clientExsists=clientsRepository.existsById(id);
//        if (!clientExsists)new RuntimeException("Sehv var");