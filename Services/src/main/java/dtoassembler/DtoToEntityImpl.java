/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.models.ClientModel;
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
    public ClientModel buildClientDto(String dataJson) {
        Validate.notNull(dataJson, "Data from client is null, can't DTO");
        ClientModel data = new Gson().fromJson(dataJson, ClientModel.class);
        return data;
    }

}
