package com.example.rentcar.service;

import com.example.rentcar.dao.entity.ClientsEntity;
import com.example.rentcar.dao.repository.ClientsRepository;
import com.example.rentcar.mapper.ClientsMapper;
import com.example.rentcar.model.ClientsDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public long totalClients(){
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
    public void saveClient(ClientsDto clientsDto) {

        clientsRepository.save(ClientsMapper.INSTANCE.mapClientsMapperDtoToEntity(clientsDto));

    }


}
