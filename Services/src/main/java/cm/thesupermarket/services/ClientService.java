/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.domain.ClientEntity;
import cm.thesupermarket.models.ClientInModel;
import cm.thesupermarket.models.ClientOutModel;
import cm.thesupermarket.models.IdInModel;
import cm.thesupermarket.models.SortModel;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public void delete(ClientInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        ClientEntity clientE = dtoToEntity.buildClientDto(data);
        clientRepository.delete(clientE);

    }

    @Override
    @Transactional
    public ClientOutModel create(ClientInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        ClientEntity clientE = dtoToEntity.buildClientDto(data);
        return entityToDto.buildClientDto(clientRepository.save(clientE));
    }

    @Override
    @Transactional
    public ClientOutModel update(ClientInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        ClientEntity clientE = dtoToEntity.buildClientDto(data);
        return entityToDto.buildClientDto(clientRepository.save(clientE));
    }

    @Override
    @Transactional
    public List<ClientOutModel> getAll(SortModel sortModel) {
        Validate.notNull(sortModel != null, "dataJson can't be empty or null");

        Page<ClientEntity> clientE = clientRepository.findAll(PageRequest.of(sortModel.getPage(), sortModel.getSize()));
        List<ClientOutModel> data = new ArrayList<>();
        clientE.forEach((cnsmr) -> {
            data.add(entityToDto.buildClientDto(cnsmr));
        });

        return data;
    }

    @Override
    @Transactional
    public ClientOutModel getClientById(IdInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        ClientEntity dataOut = null; //clientRepository.getOne(data.getId());
        return entityToDto.buildClientDto(dataOut);

    }
}


