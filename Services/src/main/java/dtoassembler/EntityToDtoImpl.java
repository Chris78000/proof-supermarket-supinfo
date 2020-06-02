/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.ClientEntity;
import cm.thesupermarket.domain.FidelityCardEntity;
import cm.thesupermarket.helpers.DateUtils;
import cm.thesupermarket.models.ClientOutModel;
import cm.thesupermarket.models.FidelityCardOutModel;

/**
 *
 * @author ryank
 */
public class EntityToDtoImpl implements EntityToDto {

    @Override
    public ClientOutModel buildClientDto(ClientEntity clientE) {
        ClientOutModel data = new ClientOutModel();
        data.setAge(clientE.getAge());
        data.setEmail(clientE.getEmail());
        data.setFirstname(clientE.getFirstname());
        data.setId(clientE.getId());
        data.setName(clientE.getName());
        data.setPhone(clientE.getPhone());
        data.setBirthday(DateUtils.convertMillisToDate(clientE.getBirthday()));
        data.setLastUpdate(DateUtils.convertMillisToDate(clientE.getLastModifiedDate()));
        data.setCreatedDate(DateUtils.convertMillisToDate(clientE.getCreationDate()));
        return data;
    }

    @Override
    public FidelityCardOutModel buildFidelityCardDto(FidelityCardEntity fidelityCard) {
        FidelityCardOutModel data = new FidelityCardOutModel();
        data.setClientId(fidelityCard.getId());
        data.setCreationDate(DateUtils.convertMillisToDate(fidelityCard.getCreationDate()));
        data.setExpiredDate(DateUtils.convertMillisToDate(fidelityCard.getExpiredDate()));
        data.setLastModifiedDate(DateUtils.convertMillisToDate(fidelityCard.getLastModifiedDate()));
        data.setNumero(fidelityCard.getNumero());
        data.setPoint(fidelityCard.getPoint());
        return data;
    }

}
