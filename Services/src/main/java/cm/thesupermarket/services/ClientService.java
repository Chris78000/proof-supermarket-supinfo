/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.domain.ClientEntity;
import cm.thesupermarket.models.ClientOutModel;
import cm.thesupermarket.repository.IClientRepository;
import dtoassembler.DtoToEntity;
import dtoassembler.EntityToDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author ryank
 */
@Service
public class ClientService implements IClient {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final IClientRepository clientRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;

    @Autowired
    public ClientService(
            @Qualifier("IClientRepository") IClientRepository clientRepository,
            DtoToEntity dtoToEntity,
            EntityToDto entityToDto
    ) {
        this.clientRepository = clientRepository;
        this.entityToDto = entityToDto;
        this.dtoToEntity = dtoToEntity;
    }

    @PostConstruct
    public void init() {
        log.info("Initializing " + getClass().getSimpleName() + " ...");
        Validate.notNull(clientRepository, "clientRepository can't be null");
        log.info(getClass().getSimpleName() + " successfully initialized");
    }

    @Override
    @Transactional
    public void delete(String dataJson) {
        Validate.isTrue(dataJson != null && !dataJson.isEmpty(), "dataJson can't be empty or null");
        ClientEntity clientE = dtoToEntity.buildClientDto(dataJson);
        clientRepository.delete(clientE);

    }

    @Override
    @Transactional
    public ClientOutModel create(String dataJson) {
        Validate.isTrue(dataJson != null && !dataJson.isEmpty(), "dataJson can't be empty or null");
        ClientEntity clientE = dtoToEntity.buildClientDto(dataJson);
        return entityToDto.buildClientDto(clientRepository.save(clientE));
    }

    @Override
    @Transactional
    public ClientOutModel update(String dataJson) {
        Validate.isTrue(dataJson != null && !dataJson.isEmpty(), "dataJson can't be empty or null");
        ClientEntity clientE = dtoToEntity.buildClientDto(dataJson);
        return entityToDto.buildClientDto(clientRepository.save(clientE));
    }

    @Override
    @Transactional
    public List<ClientOutModel> getAll(String dataJson) {
        Validate.isTrue(dataJson != null && !dataJson.isEmpty(), "dataJson can't be empty or null");
        List<ClientEntity> clientE = clientRepository.findAll();
        List<ClientOutModel> data = new ArrayList<>();
        clientE.forEach((cnsmr) -> {
            data.add(entityToDto.buildClientDto(cnsmr));
        });

        return data;
    }

    @Override
    @Transactional
    public ClientOutModel getClientById(String dataJson) {
        Validate.isTrue(dataJson != null && !dataJson.isEmpty(), "dataJson can't be empty or null");
        ClientEntity clientE = dtoToEntity.buildClientDto(dataJson);
        ClientEntity data = clientRepository.getOne(clientE.getId());
        return entityToDto.buildClientDto(data);

    }

}
