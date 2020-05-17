/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.ClientEntity;
import cm.thesupermarket.domain.CountryEntity;
import cm.thesupermarket.domain.SexEntity;
import cm.thesupermarket.helpers.DateUtils;
import cm.thesupermarket.helpers.EncrytedPasswordUtils;
import cm.thesupermarket.models.ClientInModel;
import cm.thesupermarket.models.ClientOutModel;
import com.google.gson.Gson;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ryank
 */
public class DtoToEntityImpl implements DtoToEntity {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    public DtoToEntityImpl() {
    }
    
    @Override
    public ClientEntity buildClientDto(ClientInModel data) {
        Validate.notNull(data, "Data from client is null, can't DTO");
        //  ClientInModel data = new Gson().fromJson(data, ClientInModel.class);
        ClientEntity clientE = new ClientEntity();
        clientE.setId(data.getId());
        clientE.setName(data.getName());
        clientE.setFirstname(data.getFirstname());
        clientE.setEmail(data.getEmail());
        clientE.setAge(data.getAge());
        clientE.setPhone(data.getPhone());
        clientE.setBirthday(data.getBirthday());
        
        clientE.setCreationDate(DateUtils.getTime());
        clientE.setLastModifiedDate(DateUtils.getTime());
        
        SexEntity sexE = new SexEntity();
        sexE.setId(data.getSexId());
        clientE.setSexId(sexE);
        
        CountryEntity countryE = new CountryEntity();
        countryE.setId(data.getCountryId());
        clientE.setCountryId(countryE);
        
        clientE.setPassword(EncrytedPasswordUtils.encrytePassword(data.getPassword()));
        return clientE;
    }
    
}
