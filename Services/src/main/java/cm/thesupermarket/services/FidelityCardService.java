/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.domain.FidelityCardEntity;
import cm.thesupermarket.models.FidelityCardInModel;
import cm.thesupermarket.models.FidelityCardOutModel;
import cm.thesupermarket.models.IdInModel;
import cm.thesupermarket.repository.IFidelityCardRepository;
import dtoassembler.DtoToEntity;
import dtoassembler.EntityToDto;
import javax.annotation.PostConstruct;
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
public class FidelityCardService implements IFidelityCard {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final IFidelityCardRepository fidelityCardRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;

    @Autowired
    public FidelityCardService(@Qualifier("IFidelityCardRepository") IFidelityCardRepository fidelityCardRepository, DtoToEntity dtoToEntity, EntityToDto entityToDto) {
        this.fidelityCardRepository = fidelityCardRepository;
        this.dtoToEntity = dtoToEntity;
        this.entityToDto = entityToDto;
    }

    @PostConstruct
    public void init() {
        log.info("Initializing " + getClass().getSimpleName() + " ...");
        Validate.notNull(fidelityCardRepository, "fidelityCardRepository can't be null");
        log.info(getClass().getSimpleName() + " successfully initialized");
    }

    @Override
    public void createFidelityCard(FidelityCardInModel data) {
        Validate.notNull(data, "");

    }

    @Override
    public void updateFidelityCard(FidelityCardInModel data) {
        FidelityCardEntity fidelityCE = dtoToEntity.buildFidelityCardEntityDto(data);
        fidelityCardRepository.save(fidelityCE);

    }

    @Override
    public void removeFidelityCard(FidelityCardInModel data) {
        Validate.notNull(data, "");
        fidelityCardRepository.delete(dtoToEntity.buildFidelityCardEntityDto(data));
    }

    @Override
    public FidelityCardOutModel getFidelityCard(IdInModel data) {
        Validate.notNull(data);
        FidelityCardEntity fidelityCard = fidelityCardRepository.getOne(data.getId());
        return entityToDto.buildFidelityCardDto(fidelityCard);
    }

}
