/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.models.ClientModel;
import cm.thesupermarket.repository.IClientRepository;
import dtoassembler.DtoToEntity;
import dtoassembler.EntityToDto;
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
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ClientModel create(String dataJson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ClientModel update(String dataJson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<ClientModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ClientModel getClientById(String dataJson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
