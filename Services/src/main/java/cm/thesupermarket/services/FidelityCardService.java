/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import dtoassembler.DtoToEntity;
import dtoassembler.EntityToDto;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ryank
 */
@Service
public class FidelityCardService implements IFidelityCard {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;

    @Autowired
    public FidelityCardService(DtoToEntity dtoToEntity, EntityToDto entityToDto) {
        this.dtoToEntity = dtoToEntity;
        this.entityToDto = entityToDto;
    }
    
    @PostConstruct
    public void init() {
     log.info("Initializing " + getClass().getSimpleName() + " ...");
     
     log.info(getClass().getSimpleName() + " successfully initialized");
    }

}
