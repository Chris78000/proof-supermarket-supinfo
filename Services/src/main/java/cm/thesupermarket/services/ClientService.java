/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.domain.ClientEntity;
import cm.thesupermarket.domain.ClientHasFavoritesEntity;
import cm.thesupermarket.domain.ClientHasShippingAddressEntity;
import cm.thesupermarket.domain.ClientHasShippingCardEntity;
import cm.thesupermarket.domain.FavoritesEntity;
import cm.thesupermarket.domain.ShippingAddressEntity;
import cm.thesupermarket.domain.ShippingCardEntity;
import cm.thesupermarket.helpers.DateUtils;
import cm.thesupermarket.models.ClientHasFavoritesInModel;
import cm.thesupermarket.models.ClientHasShippingAddressInModel;
import cm.thesupermarket.models.ClientHasShippingCardInModel;
import cm.thesupermarket.models.ClientInModel;
import cm.thesupermarket.models.ClientOutModel;
import cm.thesupermarket.models.IdInModel;
import cm.thesupermarket.models.SortModel;
import cm.thesupermarket.repository.IClientHasFavoritesRepository;
import cm.thesupermarket.repository.IClientHasShippingAddressRepository;
import cm.thesupermarket.repository.IClientHasShippingCardRepository;
import cm.thesupermarket.repository.IClientRepository;
import cm.thesupermarket.repository.IFavoritesRepository;
import cm.thesupermarket.repository.IShippingAddressRepository;
import cm.thesupermarket.repository.IShippingCardRepository;
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
import org.springframework.stereotype.Service;

/**
 *
 * @author ryank
 */
@Service
public class ClientService implements IClient {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final IClientRepository clientRepository;
    private final IFavoritesRepository favoritesRepository;
    private final IShippingAddressRepository shippingAddressRepository;
    private final IShippingCardRepository shippingCardRepository;
    private final IClientHasFavoritesRepository clientHasFavoritesRepository;
    private final IClientHasShippingAddressRepository clientHasShippingAddressRepository;
    private final IClientHasShippingCardRepository clientHasShippingCardRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;

    @Autowired
    public ClientService(
            @Qualifier("IClientRepository") IClientRepository clientRepository,
            @Qualifier("IFavoritesRepository") IFavoritesRepository favoritesRepository,
            @Qualifier("IShippingAddressRepository") IShippingAddressRepository shippingAddressRepository,
            @Qualifier("IShippingCardRepository") IShippingCardRepository shippingCardRepository,
            @Qualifier("IClientHasShippingCardRepository") IClientHasShippingCardRepository clientHasShippingCardRepository,
            @Qualifier("IClientHasFavoritesRepository") IClientHasFavoritesRepository clientHasFavoritesRepository,
            @Qualifier("IClientHasShippingAddressRepository") IClientHasShippingAddressRepository clientHasShippingAddressRepository,
            DtoToEntity dtoToEntity,
            EntityToDto entityToDto
    ) {
        this.clientRepository = clientRepository;
        this.favoritesRepository = favoritesRepository;
        this.shippingAddressRepository = shippingAddressRepository;
        this.shippingCardRepository = shippingCardRepository;
        this.clientHasShippingCardRepository = clientHasShippingCardRepository;
        this.clientHasFavoritesRepository = clientHasFavoritesRepository;
        this.clientHasShippingAddressRepository = clientHasShippingAddressRepository;
        this.entityToDto = entityToDto;
        this.dtoToEntity = dtoToEntity;
    }

    @PostConstruct
    public void init() {
        log.info("Initializing " + getClass().getSimpleName() + " ...");
        Validate.notNull(clientRepository, "clientRepository can't be null");
        Validate.notNull(favoritesRepository, "favoritesRepository can't be null");
        Validate.notNull(clientHasShippingCardRepository, "clientHasShippingCardRepository can't be null");
        Validate.notNull(shippingAddressRepository, "shippingAddressRepository can't be null");
        Validate.notNull(shippingCardRepository, "shippingCardRepository can't be null");
        Validate.notNull(clientHasFavoritesRepository, "clientHasFavoritesRepository can't be null");
        Validate.notNull(clientHasFavoritesRepository, "clientHasFavoritesRepository can't be null");
//        Validate.notNull(clientHasShippingAddressRepository, "clientHasShippingAddressRepository can't be null");
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

    @Override
    public void setClientHasFavorites(ClientHasFavoritesInModel dataJson) {
        Validate.notNull(dataJson);
        FavoritesEntity favE = dtoToEntity.buildFavoritesEntityDto(dataJson);
        FavoritesEntity favR = favoritesRepository.save(favE);
        ClientHasFavoritesEntity clientFE = new ClientHasFavoritesEntity();
        clientFE.setFavoritesId(favR);
        clientFE.setCreationDate(DateUtils.getTime());
        clientFE.setLastModifiedDate(DateUtils.getTime());
        ClientEntity clientE = new ClientEntity();
        clientE.setId(dataJson.getClientId());
        clientFE.setClientId(clientE);
        clientHasFavoritesRepository.save(clientFE);
    }

    @Override
    public void setClientHasShippingAddress(ClientHasShippingAddressInModel dataJson) {
        Validate.notNull(dataJson);
        ShippingAddressEntity shippingAddressE = dtoToEntity.buildShippingAddressEntityDto(dataJson);
        ShippingAddressEntity shippingAE = shippingAddressRepository.save(shippingAddressE);
        ClientHasShippingAddressEntity clientHSAE = new ClientHasShippingAddressEntity();

        clientHSAE.setShippingAddressId(shippingAE);

        ClientEntity client = new ClientEntity();
        client.setId(dataJson.getClientId());
        clientHSAE.setClientId(client);

        clientHasShippingAddressRepository.save(clientHSAE);

    }

    @Override
    public void setClientHasShippingCard(ClientHasShippingCardInModel dataJson) {
        Validate.notNull(dataJson);
        ShippingCardEntity ShippingCardE = dtoToEntity.buildShippingAddressCardEntityDto(dataJson);
        ShippingCardEntity shippingCardE = shippingCardRepository.save(ShippingCardE);
        ClientHasShippingCardEntity clientHasShippingCardE = new ClientHasShippingCardEntity();

        clientHasShippingCardE.setCreationDate(DateUtils.getTime());
        clientHasShippingCardE.setLastModifiedDate(DateUtils.getTime());

        ClientEntity clientE = new ClientEntity();
        clientE.setId(dataJson.getClientId());
        clientHasShippingCardE.setShippingCardId(shippingCardE);

    }
}
