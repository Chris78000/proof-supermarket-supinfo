/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.ClientEntity;
import cm.thesupermarket.domain.FavoritesEntity;
import cm.thesupermarket.domain.ShippingAddressEntity;
import cm.thesupermarket.domain.ShippingCardEntity;
import cm.thesupermarket.models.ClientHasFavoritesInModel;
import cm.thesupermarket.models.ClientHasShippingAddressInModel;
import cm.thesupermarket.models.ClientHasShippingCardInModel;
import cm.thesupermarket.models.ClientInModel;
import cm.thesupermarket.models.ClientOutModel;
import com.google.gson.Gson;

/**
 *
 * @author ryank
 */
public interface DtoToEntity {

    public ClientEntity buildClientDto(ClientInModel data);

    public FavoritesEntity buildFavoritesEntityDto(ClientHasFavoritesInModel data);

    public ShippingAddressEntity buildShippingAddressEntityDto(ClientHasShippingAddressInModel data);

    public ShippingCardEntity buildShippingAddressCardEntityDto(ClientHasShippingCardInModel data);
    //  public ClientHasFavoritesEntity buildClientHasFavoritesEntityDto();

}
