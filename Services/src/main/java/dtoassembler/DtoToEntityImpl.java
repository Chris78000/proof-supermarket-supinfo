/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.OrderEntity;
import cm.thesupermarket.helpers.DateUtils;
import cm.thesupermarket.helpers.EncrytedPasswordUtils;
import cm.thesupermarket.models.OrderInModel;
import cm.thesupermarket.models.OrderOutModel;
import com.google.gson.Gson;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Chris
 */
public class DtoToEntityImpl implements DtoToEntity {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    public DtoToEntityImpl() {
    }
    
    @Override
    public OrderEntity buildOrderDto(OrderInModel data) {
        Validate.notNull(data, "Data from order is null, can't DTO");
        OrderEntity orderE = new OrderEntity();
        
        orderE.setId(data.getId());
        orderE.setClientId(data.getClientId());
        orderE.setPurchaseId(data.getPurchaseId());
        orderE.setQuantity(data.getQuantity());
        orderE.setOrderDate(DateUtils.getTime());
        
        return orderE;
    }
}
